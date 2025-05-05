package day2.자습.팩토리.심플팩토리;

enum PurchasePlace {
    INTERNET,
    VISIT;
}

public interface Purchase {
    void purchase();
    PurchasePlace getPlace();
}
