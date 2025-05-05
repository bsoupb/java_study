package day2.자습.팩토리;

public class Factory {
    /*
        Factory 패턴

        [의미]
            - 객체 생성 로직을 캡슐화하는 생성 패턴
            - 객체 생성의 유연성과 확장성을 제공
            - 클라이언트 코드와 구현 객체 간의 결합도를 낮춤
        [종류]
            1. Simple Factory
            ex)
                public class SimpleFactory {
                    public static Product createProduct(String type) {
                        return switch (type) {
                            case "A" -> new ConcreteProductA();
                            case "B" -> new ConcreateProductB();
                            default -> throw new IllegalArgumentException("Unknown product type");
                        };
                    }
                }
            2. Factory Method
            ex)
                public abstract class Creator {
                    abstract Product createProduct();
                }

                public class ConcreteCreator extends Creator {
                    @Override
                    Product createProduct() {
                        return new ConcreteProduct();
                    }
                }
            3. Abstract Factory
            ex)
                public interface AbstractFactory {
                    ProductA createProductA();
                    ProductB createProductB();
                }
        [패턴 선택 가이드]
            1. Simple Factory
                - 단순한 객체 생성
                - 복잡도 낮음
                - 유연성 낮음
            2. Factory Method
                - 객체 생성을 하위 클래스에 위임
                - 복잡도 중간
                - 유연성 중간
            3. Abstract Factory
                - 연관된 객체군 생성
                - 복잡도 높음
                - 유연성 높음
        [장점]
            1. 결합도 감소
                - 객체 생성 로직 중앙화
                - 구현 변경의 영향 최소화
                - 테스트 용이성 향상
            2. 코드 재사용성
                - 객체 생성 로직 재사용
                - 중복 코드 제거
                - 일관된 객체 생성 방식
            3. 유지보수성
                - 객체 생성 로직 변경 용이
                - 새로운 제품 추가 용이
                - 코드 구조 개선

        실무 적용 가이드라인

        1. 패턴 선택 기준
            - 객체 생성 복잡도
            - 확장 가능성
            - 유지보수 요구사항
        2. 구현 시 고려사항
            - 명확한 네이밍
            - 예외 처리
            - 성능 최적화

        실무 체크리스트

        1. 설계 단계
            - 객체 생성 패턴 선택
            - 인터페이스 정의
            - 확장 가능성 검토
        2. 구현 단계
            - 팩토리 메서드 구현
            - 예외 처리 구현
            - 테스트 코드 작성
        3. 테스트 단계
            - 객체 생성 테스트
            - 예외 처리 테스트
            - 성능 테스트

        성능 최적화 전략
        1. 캐싱 적용
        ex)
            public class CachedFactory {
                private static final Map<String, Product> cache = new ConcurrentHashMap<>();

                public static Product createProduct(String type) {
                    return cache.computeIfAbsent(type, k -> createNewProduct(k));
                }
            }
        2. 지연 초기화
        ex)
            public class LazyFactory {
                private static volatile Product instance;

                public static Product getInstance() {
                    if (instance == null) {
                        synchronized(LazyFactory.class) {
                            if (instance == null) {
                                instance = new Product();
                            }
                        }
                    }
                    return instance;
                }
            }

        안티 패턴과 주의사항
        1. 과도한 추상화
        ex)
            // 안티 패턴
            public interface AbstractFactoryInterface {
                Product createProduct();
                void initializeProduct();
                void validateProduct();
                void registerProduct();
            }

            // 개선된 버전
            public interface ProductFactory {
                Product createProduct();
            }
        2. 불필요한 팩토리 계층
        ex)
            // 안티 패턴
            public class SimpleProductFactoryFactory {
                public static ProductFactory createProductFactory() {
                    return new ConcreteProductFactory();
                }
            }

            // 개선된 패턴
            public class ProductFactory {
                public static Product createProduct() {
                    return new ConcreteProduct();
                }
            }

        실무 적용 효과
        1. 코드 품질 향상
            - 버그 발생률 40% 감소
            - 코드 리뷰 시간 30% 단축
            - 유지보수 비용 35% 절감
        2. 개발 생산성
            - 새로운 기능 추가 시간 50% 단축
            - 테스트 코드 작성 시간 40% 감소
            - 리팩토링 용이성 60% 향상

     */
}
