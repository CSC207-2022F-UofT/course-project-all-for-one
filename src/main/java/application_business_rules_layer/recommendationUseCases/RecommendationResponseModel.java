package application_business_rules_layer.recommendationUseCases;

import enterprise_business_rules_layer.Recommendation;

public class RecommendationResponseModel {
    Recommendation recommendation;

    /**
     *
     * @param recommendation Recommendation object that is used to create a response model
     */
    public RecommendationResponseModel(Recommendation recommendation){
        this.recommendation = recommendation;
    }

    /**
     *
     * @return the recommendation in the response model object
     */
    public Recommendation getRecommendation() {
        return recommendation;
    }
}
