package useCase;

import entity.Order;
import entity.Post;
import entity.PurchaseHistory;
import entity.Recommendation;
import gateway.RecommendationGateway;

import java.util.ArrayList;
import java.util.List;

public class RecommendationInteractor implements RecommendationInputBoundry{
    final RecommendationOutputBoundry recommendationOutputBoundry;

    final RecommendationGateway recommendationGateway;

    public RecommendationInteractor(RecommendationOutputBoundry recommendationOutputBoundry,
                                    RecommendationGateway recommendationGateway){
        this.recommendationOutputBoundry = recommendationOutputBoundry;
        this.recommendationGateway = recommendationGateway;
    }
    @Override
    public RecommendationResponseModel create(RecommendationRequestModel recommendationRequestModel){
        List<String> Tags = new ArrayList<String>();
        for (Order order : recommendationRequestModel.purchaseHistory.getOrders()){
            Tags.add(order)
        }
        //find the most 5 tags in PurchaseHistory and BrowsingHistory
        //get in total 30 items that have at least one of these tags in the post database
        //return at most 30 items as the request model
        // if there are no 5 tags, give a string to OutputBoundry.prepareFailView

        List<String> tags = new ArrayList<>();
        Recommendation recommendation = new Recommendation(recommendationGateway.findPosts(tags));
        RecommendationResponseModel recommendationResponseModel = new RecommendationResponseModel(recommendation);
        return recommendationOutputBoundry.prepareRecommendationView(recommendationResponseModel);
    }
}
