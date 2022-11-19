package useCase;

import entity.BrowsingHistory;
import entity.PurchaseHistory;

public class RecommendationRequestModel {
     private PurchaseHistory purchaseHistory;
     private BrowsingHistory browsingHistory;

    public RecommendationRequestModel(PurchaseHistory purchaseHistory, BrowsingHistory browsingHistory){
        this.purchaseHistory = purchaseHistory;
        this.browsingHistory = browsingHistory;
    }


    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }

    public BrowsingHistory getBrowsingHistory() {
        return browsingHistory;
    }
}
