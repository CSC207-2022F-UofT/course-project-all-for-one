package useCase;

import entity.Recommendation;

public class RecommendationResponseModel {
    Recommendation recommendation;
    public RecommendationResponseModel(Recommendation recommendation){
        this.recommendation = recommendation;
    }

    public Recommendation getRecommendation() {
        return recommendation;
    }
}
