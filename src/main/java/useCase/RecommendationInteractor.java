package useCase;

import entity.Order;
import entity.Post;
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
        //find all tags in PurchaseHistory and BrowsingHistory
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

        Post[] posts = recommendationRequestModel.getBrowsingHistory().getPosts();
        for (Post post : posts){
            for(String tag :post.getTags()){
                if (!tags.containsKey(tag)) {
                    tags.put(tag, 1);
                } else {
                    tags.put(tag, tags.get(tag) + 1);
                }
            }
        }
        // if there are no 5 tags, give a string to OutputBoundry.prepareFailView

        if(tags.size() < 5){
            return recommendationOutputBoundry.prepareFailView("Please use more to have recommendation!");
        }
        //find the 5 most tags in those tags
        Integer max = 0;
        String mostTag = "";
        List<String> mostTags = new ArrayList<>();
        int i = 0;
        while (i < 4){
            for(String key: tags.keySet()){
                if (tags.get(key) > max){
                    max=tags.get(key);
                    mostTag=(key);
                }
            }
            mostTags.add(mostTag);
            tags.remove(mostTag);

            i = i+1;
        }





        //get in total 30 items that have at least one of these tags in the post database
        Recommendation recommendation = new Recommendation(recommendationGateway.findPosts(mostTags));



        RecommendationResponseModel recommendationResponseModel = new RecommendationResponseModel(recommendation);
        return recommendationOutputBoundry.prepareRecommendationView(recommendationResponseModel);
    }


}
