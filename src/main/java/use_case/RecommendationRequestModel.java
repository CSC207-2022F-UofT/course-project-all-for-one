package use_case;

import java.util.List;

public class RecommendationRequestModel {
     private List<String> purchaseHistoryTags;
     private List<String> browsingHistoryTags;

     private String username;

    /**
     *
     * @param purchaseHistoryTags purchase history of the acting user
     * @param browsingHistoryTags browsing history of the acting user
     * @param username username of the user that is acting
     */
    public RecommendationRequestModel(List<String> purchaseHistoryTags, List<String> browsingHistoryTags, String username){
        this.purchaseHistoryTags = purchaseHistoryTags;
        this.browsingHistoryTags = browsingHistoryTags;
        this.username = username;
    }

    public List<String> getPurchaseHistoryTags() {
        return purchaseHistoryTags;
    }

    public List<String> getBrowsingHistoryTags() {
        return browsingHistoryTags;
    }

    /**
     *
     * @return the username in the request model object
     */
    public String getUsername() {
        return username;
    }
}
