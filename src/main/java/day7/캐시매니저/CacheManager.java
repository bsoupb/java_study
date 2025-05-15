package day7.캐시매니저;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
    Eager Initialization
    즉시 초기화 -> 방식

    장점
        1. 구현이 간단하다. 직관적
        2. 클래스 로딩 시점에 인스턴스가 생성이 되므로 스레드가 안정하다
        3. getInstance() 메서드가 추가 동기화 없이 빠르게 실행된다

    단점
        1. 어플리케이션 시작시 바로 생성이 되기 때문에 만약에 쓰지 않는 경우 메모리 낭비 가능성이 큼
        2. 초기화 과정에서 발생할 수 있는 예외를 클라이언트가 처리할 방법이 없음

 */
public class CacheManager {
    private static final CacheManager INSTANCE = new CacheManager();

    // ConcurrentHashMap -> 동시성 문제 해결
    private final Map<String, Object> cache;

    private final long defaultExpirationTime;   // 캐시 만료 시간

    // 기본생성자 막아줌
    private CacheManager() {
        this.cache = new ConcurrentHashMap<>();
        this.defaultExpirationTime = 3600000;
    }

    // 반환
    public static CacheManager getInstance() {
        return INSTANCE;
    }

    // 캐시 관련 메서드
    public void put(String key, Object value) {
        put(key, value, defaultExpirationTime);
    }

    public void put(String key, Object value, long expirationTime) {
        if(key == null) {
            throw new IllegalArgumentException("캐시 키는 null 일 수 없습니다.");
        }

        CacheItem cacheItem = new CacheItem(value, System.currentTimeMillis() + expirationTime);
        cache.put(key, cacheItem);
    }

    public Object get(String key) {
        if(key == null) {
            return null;
        }

        Object item = cache.get(key);
        if (item == null) {
            return null;
        }

        // 캐시아이템 타입 확인
        if(item instanceof CacheItem) {
            CacheItem cacheItem = (CacheItem) item;

            if(cacheItem.isExpired()) {
                cache.remove(key);
                return null;
            }
            return cacheItem.getValue();
        }
        return item;
    }

    // 캐싱 항목을 래핑하는 내부 클래스
    @Getter
    private static class CacheItem {
        private final Object value;
        private final long expirationTime;

        public CacheItem(Object value, long expirationTime) {
            this.value = value;
            this.expirationTime = expirationTime;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() > expirationTime;
        }

    }
}
