package purchase_use_case;

public interface PurchaseOutputBoundary {
    PurchaseResponseModel preparePurchaseView(PurchaseResponseModel purchaseResponse);
}
