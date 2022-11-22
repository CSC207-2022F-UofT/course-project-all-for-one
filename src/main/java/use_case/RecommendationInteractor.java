package use_case;

import Entity.Recommendation;
import gateway.RecommendationGateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendationInteractor implements RecommendationInputBoundry{
    final RecommendationOutputBoundry recommendationOutputBoundry;

    final RecommendationGateway recommendationGateway;

    /**
     *
     * @param recommendationOutputBoundry
     * @param recommendationGateway
     */
    public RecommendationInteractor(RecommendationOutputBoundry recommendationOutputBoundry,
                                    RecommendationGateway recommendationGateway){
        this.recommendationOutputBoundry = recommendationOutputBoundry;
        this.recommendationGateway = recommendationGateway;
    }

    /**
     *
     * @param recommendationRequestModel the RecommendationRequestModel that serves as the input needed processing
     * @return the RecommendationResponseModel object that contains a list of posts from the database that
     * contain a specific set of tags in recommendationRequestModel
     */
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
        while (i < 5){
            for(String key: tags.keySet()){
                if (tags.get(key) > max){
                    max=tags.get(key);
                    mostTag = key;
                }
            }
            mostTags.add(mostTag);
            tags.remove(mostTag);

            i = i+1;
        }





        //get in total 30 items that have at least one of these tags in the post database
        Recommendation recommendation = new Recommendation(recommendationGateway.findPosts(mostTags, recommendationRequestModel.getUsername()));



        RecommendationResponseModel recommendationResponseModel = new RecommendationResponseModel(recommendation);
        return recommendationOutputBoundry.prepareRecommendationView(recommendationResponseModel);
    }


}
