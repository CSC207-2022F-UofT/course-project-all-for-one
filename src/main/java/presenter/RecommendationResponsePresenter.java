package presenter;

import useCase.RecommendationOutputBoundry;
import useCase.RecommendationResponseModel;

public class RecommendationResponsePresenter implements RecommendationOutputBoundry {
    @Override
    public RecommendationResponseModel prepareRecommendationView(RecommendationResponseModel recommendationResponseModel){
        return recommendationResponseModel;
    }

    @Override
    public RecommendationResponseModel prepareFailView(String error){
        throw new RecommmendationFailedError(error);
    }
}
