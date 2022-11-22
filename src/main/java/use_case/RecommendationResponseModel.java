package use_case;

import entity.Recommendation;

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