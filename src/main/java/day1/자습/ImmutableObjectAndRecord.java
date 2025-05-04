package day1.자습;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class ImmutableObjectAndRecord {
    /*
        불변객체
        [의미]
        - 생성 후에 그 상태를 바꿀 수 없는 객체
        [만드는 방법]
        1. 클래스를 final로 선언하여 상속 막음
        2. 모든 필드를 private과 final로 선언
        3. 모든 필드에 대한 getter는 제공, setter는 제공하지 않음
        4. 참조 타입 필드에 대해 방어적 복사 사용
        5. 객체 상태 변경이 필요한 경우, 새 객체 생성하여 반환
     */

    // record
    public record PersonRecord(String name, int age) {}

    // 불변객체
    public final class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String name() {
            return name;
        }

        public int age() {
            return age;
        }
    }

    /*
        [장점]
        1. 스레드 안전성
            - 불변 객체는 동기화 없이도 스레드 안전
            - 여러 스레드가 동시에 접근해도 상태가 변하지 않으므로 동시성 문제 발생하지 않음
        2. 캐싱 최적화
            - 항상 동일한 상태 유지하므로 안전하게 캐시할 수 있음
            - 자주 사용되는 값은 미리 생성하여 재사용 가능
        3. 디버깅 용이성
            - 상태 변경 추적 필요 없어서 디버깅 용이
            - 버그 발생 가능성 줄어듦
        4. 테스트 용이성
            - 사이드 이펙트가 없어 테스트 간단
            - 예측 가능한 동작으로 테스트 케이스 작성 쉬움
        5. 함수형 프로그래밍 친화적
            - 상태 변경 없이 값을 전달하고 변환하는 패턴에 적합
     */
    
    public final class Book {
        private final String isbn;
        private final String title;
        private final String author;
        private final LocalDate publishDate;
        private final int pageCount;
        
        public Book(String isbn, String title, String author, LocalDate publishDate, int pageCount) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.publishDate = publishDate;
            this.pageCount = pageCount;
        }
        
        // getter
    }
    
    public record BookRecord(
            String isbn,
            String title,
            String author,
            LocalDate publishDate,
            int pageCount
    ) {
        public BookRecord {
            Objects.requireNonNull(isbn, "ISBN must not be null");
        }
        
        public boolean isRecentPublication() {
            return publishDate.isAfter(LocalDate.now().minusYears(5));
        }
    }
    
    /*
        [추가사항]
        1. Record 제약사항
            - 다른 클래스를 상속할 수 없음(자체가 암시적으로 java.lang.Record 상속)
            - 항상 final 클래스
            - 필드는 항상 private final
            - 인스턴스 초기화 블록 포함할 수 없음
        2. 고급 불변 객체 패턴
            - 빌더 패턴과 불변 객체의 결합
            - 중첩된 불변 컬렉션 처리
            - 효율적인 불변 컬렉션 구현 방법
        3. 다양한 활용 사례
            - 설정 객체(Configuration objects)
            - Value Objects in Domain-Driven Design
            - 이벤트 객체(Event objects)
            - 메시지 객체(Message objects)
        4. 성능 고려사항
            - 불변 객체 사용 시 메모리 사용량 최적화
            - 객체 생성 오버헤드 관리
            - 효율적인 복제 전략
        5. 함수형 프로그래밍과의 연계
            - Java Stream API와 불변 객체
            - 함수형 인터페이스와 불변 객체
            - 불변 데이터 파이프라인 구축
     */

}
