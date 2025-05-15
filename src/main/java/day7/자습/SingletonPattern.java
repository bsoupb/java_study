package day7.자습;

/*
    싱글톤 패턴(Singleton Pattern)

    [개요]
        - 싱글톤 패턴은 클래스의 인스턴스가 애플리케이션 내에서 하나만 존재하도록 보장하는 디자인 패턴
        - 전역 상태를 관리하거나 공유 리소스에 대한 접근을 제어할 때 유용

    [주요 특징]
        1. 단일 인스턴스: 클래스의 인스턴스가 전체 애플리케이션에서 오직 하나만 존재
        2. 전역 접근성: 어디서든 해당 인스턴스에 접근 가능 (static)
        3. 지연 초기화(선택적): 필요한 시점에만 인스턴스 생성 가능

    [구현 방법]
        1. Double-checked Locking 패턴
            ex)
            public class DatabaseConnectionManager {
                private static volatile DatabaseConnectionManager instance;

                private DatabaseConnectionManager() { ... }

                public static DatabaseConnectionManager getInstance() {
                    if (instance == null) {
                        synchronized (DatabaseConnectionManager getInstance() {
                            if (instance == null) {
                                instance = new DatabaseConnectionManager();
                            }
                        }
                    }
                    return instance;
                }
            }
            - 장점: 지연 초기화와 스레드 안전성을 모두 제공
            - 단점: 코드가 다소 복잡하고, Java 1.5 이전에는 volatile이 제데로 작동하지 않음
            - 사용 시나리오: 인스턴스 생성 비용이 크고, 멀티스레드 환경에서 효율적인 초기화가 필요한 경우
        2. Eager Initialization 패턴
            ex)
            public class CacheManager {
                private static final CacheManager INSTANCE = new CacheManager();

                private CacheManager() { ... }

                public static CacheManager getInstance() {
                    return INSTANCE;
                }
            }
            - 장점: 구현이 간단하고 스레드 안전성이 보장됨
            - 단점: 클래스 로딩 시점에 인스턴스가 생성되므로, 사용하지 않는 경우 자원 낭비가 발생할 수 있음
            - 사용 시나리오: 인스턴스 생성 비용이 크지 않고 항상 사용되는 경우
        3. Enum 패턴
            ex)
            public enum ConfigurationManager {
                INSTANCE;

                // 메서드 및 필드 ...

                public String getProperty(String key) { ... }
            }
            - 장점: 가장 간결하고 안전한 싱글톤 구현, 리플렉션 및 직렬화에도 안전
            - 단점: 클래스 상속이 불가능하고, 지연 초기화가 불가능
            - 사용 시나리오: 단순한 싱글톤이 필요하며 확장성이 중요하지 않은 경우
        4. Holder 패턴
            ex)
            public class LogManager {
                private static class LazyHolder {
                    private static final LogManager INSTANCE = new LogManager();
                }

                private LogManager() { ... }

                public static LogManager getInstance() {
                    return LazyHolder.INSTANCE;
                }
            }
            - 장점: 지연 초기화와 스레드 안전성을 모두 제공, 코드 간결
            - 단점: Java의 클래스 로딩 메커니즘에 의존
            - 사용 시나리오: 지연 초기화와 스레드 안전성이 모두 필요한 경우
        5. 정적 팩토리 메서드 패턴
            ex)
            public class ThreadPoolManager {
                private static class InstanceHolder {
                    private static final ThreadPoolManager INSTANCE = new ThreadPoolManager();
                }

                private ThreadPoolManager() { ... }

                public static ThreadPoolManager() { ... }

                // 다양한 팩토리 페서드 제공
                public ExecutorService getCpuBoundExecutor() { ... }
                public ExecutorService getIoBoundExecutor() { ... }
            }
            - 장점: 하나의 싱글톤 객체를 통해 다양한 서비스 제공 가능
            - 단점: 단일 책임 원칙에 위배될 수 있음
            - 사용 시나리오: 관련된 여러 서비스를 통합 관리해야 하는 경우
        6. 의존성 주입 패턴
            ex)
            public class ApplicationContext {
                private static class ContextHolder {
                    private static final ApplicationContext INSTANCE = new ApplicationContext();
                }

                private ApplicationContext() { ... }

                public static ApplicationContext getInstance() {
                    return ContextHolder.INSTANCE;
                }

                public <T> void register(Class<T> type, T instance) { ... }
                public <T> T getBean(Class<T> type) { ... }
            }
            - 장점: 테스트 용이성 및 느슨한 결합을 제공
            - 단점: 구현이 복잡하고, 모든 의존성을 수동 등록해야 함
            - 사용 시나리오: 테스트 가능성과 확장성이 중요한 대규모 애플리케이션

    [싱글톤 패턴 적용 사례]
        1. 데이터베이스 연결 관리: 데이터베이스 연결은 비용이 많이 들어 하나의 인스턴스를 공유하는 것이 효율적
        2. 캐시 관리: 동일한 데이터에 대한 중복 요청을 줄이기 위한 캐시 시스템
        3. 설정 관리: 애플리케이션 설정을 중앙에서 관리하기 위한 시스템
        4. 로깅 시스템: 로그 파일에 대한 일관된 접근을 제공하는 로깅 시스템
        5. 스레드 풀: 제한된 수의 스레드를 재사용하기 위한 스레드 풀 관리자

    [싱글톤 패턴 장점]
        1. 메모리 효율성: 하나의 인스턴스만 생성되므로 메모리 사용이 효율적
        2. 일관된 결과: 애플리케이션 전체에서 동일한 인스턴스를 사용하므로 일관성이 보장됨
        3. 전역 접근성: 애플리케이션 어디서든 쉽게 접근 가능

    [싱글톤 패턴 단점]
        1. 테스트 어려움: 전역 상태로 인해 단위 테스트가 어려울 수 있음
        2. 숨겨진 의존성: 코드 간 의존성이 명시적이지 않아 코드 이해도가 떨어질 수 있음
        3. 스레드 안전성: 멀티스레드 환경에서 추가적인 주의가 필요
        4. SRP 위반: 싱글톤 클래스가 인스턴스 관리와 비즈니스 로직을 모두 담당하게 될 수 있음
        
    [주의사항]
        1. 스레드 안전성: 멀티스레드 환경에서 안전하게 동작하도록 구현해야 함
        2. 직렬화 주의: 직렬화/역직렬화 과정에서 새로운 인스턴스가 생성될 수 있음
        3. 리플렉션 대응: 리플렉션을 통한 private 생성자 접근 방지해야 함
        4. 테스트 가능성: 의존성 주입 등을 통해 테스트 가능한 구조를 유지해야 함

 */

public class SingletonPattern {
}
