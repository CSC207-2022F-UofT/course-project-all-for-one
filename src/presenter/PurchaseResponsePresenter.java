package presenter;

import purchase_use_case.PurchaseResponseModel;
import purchase_use_case.PurchaseOutputBoundary;

public class PurchaseResponsePresenter implements PurchaseOutputBoundary {
    @Override
    public PurchaseResponseModel preparePurchaseView(PurchaseResponseModel purchaseResponse){
        return purchaseResponse;
    }
}
