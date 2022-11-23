package controller;


import gateway.RecommendationGateway;
import use_case.RecommendationInputBoundry;
import use_case.RecommendationRequestModel;
import use_case.RecommendationResponseModel;

import java.util.List;

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
        List<String> purchaseHistoryTags = recommendationGateway.getPurchaseHistoryTags(username);
        List<String> browsingHistoryTags = recommendationGateway.getBrowsingHistoryTags(username);

        RecommendationRequestModel recommendationRequestModel =
                new RecommendationRequestModel(purchaseHistoryTags, browsingHistoryTags, username);

        return recommendationInputBoundry.create(recommendationRequestModel);
    }
}

