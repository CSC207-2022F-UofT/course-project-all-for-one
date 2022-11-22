package controller;


import entity.BrowsingHistory;
import entity.PurchaseHistory;
import gateway.RecommendationGateway;
import use_case.RecommendationInputBoundry;
import use_case.RecommendationRequestModel;
import use_case.RecommendationResponseModel;

public class RecommendationController {
    String username;
    final RecommendationInputBoundry recommendationInputBoundry;
    final RecommendationGateway recommendationGateway;

    /**
     *
     * @param username user with username that is acting
     * @param userRecommendationInput a RecommendationInteractor instance variable
     * @param recommendationGateway a RecommendationFilesGateway instance variable
     */
    public RecommendationController(String username, RecommendationInputBoundry userRecommendationInput, RecommendationGateway recommendationGateway){
        this.username = username;
        this.recommendationInputBoundry = userRecommendationInput;
        this.recommendationGateway = recommendationGateway;
    }

    /**
     *
     * @return return a responsemodel to UI to handle
     */
    public RecommendationResponseModel generate() {
        PurchaseHistory purchaseHistory = recommendationGateway.getPurchaseHistory(username);
        BrowsingHistory browsingHistory = recommendationGateway.getBrowsingHistory(username);

        RecommendationRequestModel recommendationRequestModel =
                new RecommendationRequestModel(purchaseHistory, browsingHistory, username);

        return recommendationInputBoundry.create(recommendationRequestModel);
    }
}

