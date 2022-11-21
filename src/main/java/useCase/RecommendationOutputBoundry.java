package useCase;

public interface RecommendationOutputBoundry {
    /**
     *
     * @param recommendationResponseModel the input that needs processing
     * @return return a RecommendationResponseModel object if there is no error
     */
    RecommendationResponseModel prepareRecommendationView(RecommendationResponseModel recommendationResponseModel);

    /**
     *
     * @param error a String that is used to create an Error object
     * @return return a response model that is actually an error
     */
    RecommendationResponseModel prepareFailView(String error);
}
