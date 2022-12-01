package application_business_rules_layer.recommendationUseCases;

import java.util.List;

public class RecommendationRequestModel {
     private final List<String> purchaseHistoryTags;

     private final String username;

    /**
     *
     * @param purchaseHistoryTags purchase history of the acting user
     * @param username username of the user that is acting
     */
    public RecommendationRequestModel(List<String> purchaseHistoryTags, String username){
        this.purchaseHistoryTags = purchaseHistoryTags;
        this.username = username;
    }

    public List<String> getPurchaseHistoryTags() {
        return purchaseHistoryTags;
    }


    /**
     *
     * @return the username in the request model object
     */
    public String getUsername() {
        return username;
    }
}
