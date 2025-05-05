package day2.자습.빌더패턴;

public class BuilderPattern {
    /*
        빌더 패턴(Builder Pattern)

        [의미]
            - 복잡한 객체의 생성 과정과 표현 방법을 분리하여 다양한 구성의 인스턴스를 만드는 생성 패턴
            - 복잡한 객체를 생성하는 방법과 표현하는 방법을 정의하는 클래스를 별도로 분리하여, 서로 다른 표현이라도 이를 생성할 수 있는 동일한 절차 제공

        [도입배경]
            1. 생성자 오버로딩 한계
                - 생성자 급증 (RequiredArgsConstructor 많음)
                - 매개변수 순서 혼동 (같은 타입의 매개변수 여러 개)
                - 가독성 저하
                - 특정 조합의 매개변수만 설명하기 어려움 (일정 매개변수만 설정, 나머지는 기본값)
            2. 자바빈 패턴과 일관성 문제
                - 생성자 오버로딩의 대안으로 setter 메서드를 사용하는 자바빈 패턴 있음
            * 객체 일관성 깨지는 이유
                - 부분적 초기화 상태: setter 호출 사이에 객체가 불완전한 상태로 존재
                - 스레드 안전성 문제: 다중 스레드 환경에서 한 스레드가 객체를 초기화하는 도중에 다른 스레드가 완전히 초기화되지 않은 객체에 접근 가능
                - 복합적 유효성 검증 불가: 각 setter는 개별 필드만 검증 가능, 여러 필드 간의 관계를 검증하기 어려움
                - 불변 객체 생성 불가: setter 메서드가 public 으로 노출되어 있어 객체 생성 후에도 상태가 언제든지 변경 가능
                - 필수 필드 보장 불가: 필수 필드에 대한 setter를 호출하지 않을 수 있으며, 컴파일러가 강제할 방법 없음
        [장점]
            1. 가독성 향상: 메서드 체이닝 통해 객체 생성
            2. 유연성: 필수 매개변수와 선택적 매개변수 구분 가능
            3. 불변성 확보: 객체가 생성된 후에 상태를 변경할 수 없는 불변 객체 만들 수 있음
            4. 유효성 검증: 객체 생성 전에 모든 값의 유효성 한 번에 검증 가능
            5. 명확한 API: 메서드 이름으로 어떤 값을 설정하는지 알 수 있어 순서 혼동 문제 없음
            6. 단계적 객체 생성: 복잡한 객체를 여러 단계로 나누어 생성
        [구조]
            1. Product: 빌더 패턴으로 생성될 객체
            2. Builder: 제품 객체의 다양한 부분을 생성하는 추상 인터페이스
            3. ConcreteBuilder: Builder 인터페이스를 구현하여 제품의 부분을 조립하는 구체적인 클래스
            4. Director: Builder를 사용하여 객체를 생성하는 클래스 (선택적)
        [구현방법]
            - 내부 정적 클래스를 사용하여 빌더 패턴 구현

            public class Product {
                1. 필드: final로 불변성 확보
                private final String field1;
                private final int field2;
            }

            2. private 생성자
            private Product(Builder builder) {
                // 필드 초기화
                this.field1 = builder.field1;
                this.field2 = builder.field2;
            }

            3. 정적 내부 빌더 클래스
            public static class Builder {
                // 필수 필드
                private final String field1;

                // 선택적 필드 - 기본값 설정
                private int field2 = 0;

                // 필수 값을 받는 생성자
                public Builder(String field1) {
                    this.field1 = field1;
                }

                // 선택적 값을 설정하는 메서드들 (메서드 체이닝을 위해 Builder 반환)
                public Builder field2(int val) {
                    this.field2 = val;
                    return this;
                }

                // build 메서드로 최종 객체 생성
                public Product build() {
                    return new Product(this);
                }
            }
        4. 빌더 패턴 사용
            Product product = new Product.Builder("필수값")
                .field2(42)
                .build();
        [빌더 패턴의 사용이 적합한 경우]
            1. 생성자에 많은 매개변수가 필요한 경우
            2. 일부 매개변수가 선택적인 경우
            3. 객체의 불변성이 중요한 경우
            4. 객체 생성 시 유효성 검증이 필요한 경우
            5. 객체 생성 과정이 복잡한 경우
            -> 객체 생성 과정이 복잡하고 다양한 표현이 필요할 때
        [다른 생성 패턴과의 비교]
            - 팩토리 메서드 패턴: 객체 생성을 서브클래스에 위임
            - 추상 팩토리 패턴: 관련된 객체들의 집합을 생성
            - 프로토타입 패턴: 기존 객체를 복제하여 새 객체 생성
            - 싱글톤 패턴: 클래스의 인스턴스가 하나만 생성되도록 보장
        [실제 사용 사례]
            - StringBuilder, StringBuffer
            - java.nio.ByteBuffer, CharBuffer 등
            - Lombok의 @Builder 어노테이션
            - Spring의 UriComponentsBuilder
            - Retrofit의 Request 빌더
        [주의사항]
            - 빌더 패턴은 코드량 증가할 수 있음(내부 클래스 추가)
            - 간단한 객체에는 과도한 패턴일 수 있음
            - Lombok의 @Builder 사용시 커스텀 유효성 검증에 주의
     */

}

