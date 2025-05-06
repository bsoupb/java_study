package day2.자습.팩토리.심플팩토리;

public class PurchaseService {
    public void processPurchase(PurchasingMethod method) {
        Purchase purchase = PurchasingFactory.buyBook(method);

        PurchasePlace place = purchase.getPlace();
    }
}
