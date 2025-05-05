package day2.자습.팩토리.심플팩토리;

public class AladinPurchase implements Purchase {
    private PurchasePlace place = PurchasePlace.VISIT;

    @Override
    public void purchase() {
        place = PurchasePlace.INTERNET;
    }

    @Override
    public PurchasePlace getPlace() {
        return place;
    }
}
