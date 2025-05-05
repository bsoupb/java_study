package day2.자습.팩토리.심플팩토리;

public class PurchasingFactory {
    public static Purchase buyBook(PurchasingMethod method) {
        return switch (method) {
            case ALADIN -> new AladinPurchase();
            case KYOBO -> new KyoboPurchase();
            default -> throw new IllegalArgumentException("Unsupported purchase method");
        };
    }
}

/*
    Purchase를 반환하는 이유
        - 다양한 구매 방식의 공통 인터페이스를 제공 (AladinPurchase, KyoboPurchase가 Purchase를 구현하고 있음)
        - 클라이언트 코드의 유연성과 확장성을 확보
        - SOLID 원칙(특히 OCP, DIP)을 지키기 위함
 */