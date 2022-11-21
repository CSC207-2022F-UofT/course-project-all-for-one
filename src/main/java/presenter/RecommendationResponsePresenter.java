package presenter;

import useCase.RecommendationOutputBoundry;
import useCase.RecommendationResponseModel;

public class RecommendationResponsePresenter implements RecommendationOutputBoundry {
    /**
     *
     * @param recommendationResponseModel the input that needs processing
     * @return return a RecommendationResponseModel object if there is no error
     */
    @Override
    public RecommendationResponseModel prepareRecommendationView(RecommendationResponseModel recommendationResponseModel){
        return recommendationResponseModel;
    }

    /**
     *
     * @param error a String that is used to create an Error object
     * @return return a response model that is actually an error
     */
    @Override
    public RecommendationResponseModel prepareFailView(String error){
        throw new RecommendationFailedError(error);
    }
}
