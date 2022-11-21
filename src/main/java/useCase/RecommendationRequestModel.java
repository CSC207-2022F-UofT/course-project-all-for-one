package useCase;

import entity.BrowsingHistory;
import entity.PurchaseHistory;

public class RecommendationRequestModel {
     private PurchaseHistory purchaseHistory;
     private BrowsingHistory browsingHistory;

     private String username;

    public RecommendationRequestModel(PurchaseHistory purchaseHistory, BrowsingHistory browsingHistory, String username){
        this.purchaseHistory = purchaseHistory;
        this.browsingHistory = browsingHistory;
        this.username = username;
    }


    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }

    public BrowsingHistory getBrowsingHistory() {
        return browsingHistory;
    }

    public String getUsername() {
        return username;
    }
}
