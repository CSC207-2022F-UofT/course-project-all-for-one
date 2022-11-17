package useCase;

import entity.Order;
import entity.Post;
import entity.PurchaseHistory;
import entity.Recommendation;
import gateway.RecommendationGateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Integer> tags = new HashMap<>();
        for (Order order : recommendationRequestModel.getPurchaseHistory().getOrders()){
            for(String tag :order.getPost().getTags()){
                if (!tags.containsKey(tag)) {
                    tags.put(tag, 1);
                } else {
                    tags.put(tag, tags.get(tag) + 1);
                }
            }
        }

        Post[] posts = recommendationRequestModel.getBrowsingHistory().getPosts()
        for (Post post : posts){
            for(String tag :post.getTags()){
                if (!tags.containsKey(tag)) {
                    tags.put(tag, 1);
                } else {
                    tags.put(tag, tags.get(tag) + 1);
                }
            }
        }
        //find the most 5 tags in PurchaseHistory and BrowsingHistory
        //get in total 30 items that have at least one of these tags in the post database
        //return at most 30 items as the request model
        // if there are no 5 tags, give a string to OutputBoundry.prepareFailView


        Recommendation recommendation = new Recommendation(recommendationGateway.findPosts(tags));
        RecommendationResponseModel recommendationResponseModel = new RecommendationResponseModel(recommendation);
        return recommendationOutputBoundry.prepareRecommendationView(recommendationResponseModel);
    }


}
