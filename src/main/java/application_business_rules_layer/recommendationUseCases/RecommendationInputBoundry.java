package application_business_rules_layer.recommendationUseCases;

public interface RecommendationInputBoundry {
    /**
     *
     * @param recommendationRequestModel the RecommendationRequestModel that serves as the input needed processing
     * @return the RecommendationResponseModel object that is the output after processing
     */
    RecommendationResponseModel create(RecommendationRequestModel recommendationRequestModel);
}
