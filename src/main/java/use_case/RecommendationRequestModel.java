package use_case;

import entity.BrowsingHistory;
import entity.PurchaseHistory;

public class RecommendationRequestModel {
     private PurchaseHistory purchaseHistory;
     private BrowsingHistory browsingHistory;

     private String username;

    /**
     *
     * @param purchaseHistory purchase history of the acting user
     * @param browsingHistory browsing history of the acting user
     * @param username username of the user that is acting
     */
    public RecommendationRequestModel(PurchaseHistory purchaseHistory, BrowsingHistory browsingHistory, String username){
        this.purchaseHistory = purchaseHistory;
        this.browsingHistory = browsingHistory;
        this.username = username;
    }

    /**
     *
     * @return the purchaseHistory in the request model object
     */
    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }

    /**
     *
     * @return the browsing history in the request model object
     */
    public BrowsingHistory getBrowsingHistory() {
        return browsingHistory;
    }

    /**
     *
     * @return the username in the request model object
     */
    public String getUsername() {
        return username;
    }
}
