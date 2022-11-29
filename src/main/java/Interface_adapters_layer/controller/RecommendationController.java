package Interface_adapters_layer.controller;


import application_business_rules_layer.recommendationUseCases.RecommendationGateway;
import application_business_rules_layer.recommendationUseCases.RecommendationInputBoundry;
import application_business_rules_layer.recommendationUseCases.RecommendationRequestModel;
import application_business_rules_layer.recommendationUseCases.RecommendationResponseModel;

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
     * @return return a responsemodel to framworks_drivers.UI to handle
     */
    public RecommendationResponseModel generate() {
        List<String> purchaseHistoryTags = recommendationGateway.getPurchaseHistoryTags(username);
        List<String> browsingHistoryTags = recommendationGateway.getBrowsingHistoryTags(username);

        RecommendationRequestModel recommendationRequestModel =
                new RecommendationRequestModel(purchaseHistoryTags, browsingHistoryTags, username);

        return recommendationInputBoundry.create(recommendationRequestModel);
    }
}

