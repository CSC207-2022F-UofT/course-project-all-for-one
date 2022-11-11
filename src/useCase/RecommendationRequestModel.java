package useCase;

import entity.BrowsingHistory;
import entity.PurchaseHistory;

public class RecommendationRequestModel {
    PurchaseHistory purchaseHistory;
    BrowsingHistory browsingHistory;

    public RecommendationRequestModel(PurchaseHistory purchaseHistory, BrowsingHistory browsingHistory){
        this.purchaseHistory = purchaseHistory;
        this.browsingHistory = browsingHistory;
    }


}
