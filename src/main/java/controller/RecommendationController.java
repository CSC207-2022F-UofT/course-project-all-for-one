package controller;


import entity.BrowsingHistory;
import entity.PurchaseHistory;
import gateway.RecommendationGateway;
import useCase.RecommendationInputBoundry;
import useCase.RecommendationRequestModel;
import useCase.RecommendationResponseModel;

public class RecommendationController {
    String username;
    final RecommendationInputBoundry recommendationInputBoundry;
    final RecommendationGateway recommendationGateway;


    public RecommendationController(String username, RecommendationInputBoundry userRecommendationInput, RecommendationGateway recommendationGateway){
        this.username = username;
        this.recommendationInputBoundry = userRecommendationInput;
        this.recommendationGateway = recommendationGateway;
    }

    public RecommendationResponseModel generate() {
        PurchaseHistory purchaseHistory = recommendationGateway.getPurchaseHistory(username);
        BrowsingHistory browsingHistory = recommendationGateway.getBrowsingHistory(username);

        RecommendationRequestModel recommendationRequestModel =
                new RecommendationRequestModel(purchaseHistory, browsingHistory);

        return recommendationInputBoundry.create(recommendationRequestModel);
    }
}

