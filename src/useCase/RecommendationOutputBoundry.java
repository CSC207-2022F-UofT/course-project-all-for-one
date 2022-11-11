package useCase;

public interface RecommendationOutputBoundry {
    RecommendationResponseModel prepareRecommendationView(RecommendationResponseModel recommendationResponseModel);

    RecommendationResponseModel prepareFailView(String error);
}
