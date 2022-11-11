package controller;

import entity.BrowsingHistory;
import entity.PurchaseHistory;
import useCase.RecommendationInputBoundry;
import useCase.RecommendationResponseModel;
import useCase.RecommendationRequestModel;

public class RecommendationController {

    final RecommendationInputBoundry recommendationInputBoundry;

    public RecommendationController(RecommendationInputBoundry userRecommendationInput){
        this.recommendationInputBoundry = userRecommendationInput;
    }

    public RecommendationResponseModel generate(PurchaseHistory purchaseHistory, BrowsingHistory browsingHistory) {
        RecommendationRequestModel recommendationRequestModel =
                new RecommendationRequestModel(purchaseHistory, browsingHistory);

        return recommendationInputBoundry.create(recommendationRequestModel);
    }
}

