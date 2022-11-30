package Interface_adapters_layer.controller;


import application_business_rules_layer.recommendationUseCases.RecommendationInputBoundry;
import application_business_rules_layer.recommendationUseCases.RecommendationRequestModel;
import application_business_rules_layer.recommendationUseCases.RecommendationResponseModel;
import application_business_rules_layer.tradeUseCases.OrderDsGateway;

import java.util.List;

public class RecommendationController {
    String username;
    final RecommendationInputBoundry recommendationInputBoundry;
    final OrderDsGateway orderDsGateway;

    /**
     *
     * @param username user with username that is acting
     * @param userRecommendationInput a RecommendationInteractor instance variable
     * @param orderDsGateway a RecommendationFilesGateway instance variable
     */
    public RecommendationController(String username, RecommendationInputBoundry userRecommendationInput, OrderDsGateway orderDsGateway){
        this.username = username;
        this.recommendationInputBoundry = userRecommendationInput;
        this.orderDsGateway = orderDsGateway;
    }

    /**
     *
     * @return return a responsemodel to framworks_drivers.UI to handle
     */
    public RecommendationResponseModel generate() {
        List<String> purchaseHistoryTags = orderDsGateway.getPurchaseHistoryTagsData(username);

        RecommendationRequestModel recommendationRequestModel =
                new RecommendationRequestModel(purchaseHistoryTags, username);

        return recommendationInputBoundry.create(recommendationRequestModel);
    }
}

