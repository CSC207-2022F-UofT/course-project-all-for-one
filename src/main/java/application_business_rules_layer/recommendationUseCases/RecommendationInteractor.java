package application_business_rules_layer.recommendationUseCases;

import application_business_rules_layer.postUseCases.PostDsGateway;
import enterprise_business_rules_layer.Recommendation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendationInteractor implements RecommendationInputBoundry{
    final RecommendationOutputBoundry recommendationOutputBoundry;

    final PostDsGateway postDsGateway;

    /**
     *
     * @param recommendationOutputBoundry relay to Interface_adapters.presenter
     * @param postDsGateway Interface_adapters.gateway to reach post file
     */
    public RecommendationInteractor(RecommendationOutputBoundry recommendationOutputBoundry,
                                    PostDsGateway postDsGateway){
        this.recommendationOutputBoundry = recommendationOutputBoundry;
        this.postDsGateway= postDsGateway;
    }

    /**
     *
     * @param recommendationRequestModel the RecommendationRequestModel that serves as the input needed processing
     * @return the RecommendationResponseModel object that contains a list of posts from the database that
     * contain a specific set of tags in recommendationRequestModel
     */
    @Override
    public RecommendationResponseModel create(RecommendationRequestModel recommendationRequestModel) {
        //find all tags in PurchaseHistory
        Map<String, Integer> tags = new HashMap<>();




        for (String tag : recommendationRequestModel.getPurchaseHistoryTags()) {
            boolean contain = false;
            for(String tagsAdded: tags.keySet()){
                if (tag.contains(tagsAdded)) {
                    contain = true;
                    break;
                }
            }
            if (!tags.containsKey(tag) && !contain) {
                tags.put(tag, 1);
            } else {
                tags.put(tag, tags.get(tag) + 1);
            }
        }

        // if there are no 3 tags, give a string to OutputBoundry.prepareFailView

        if(tags.size() < 3){
            return recommendationOutputBoundry.prepareFailView("Please use more to have recommendation!");
        }
//        find the 3 most tags in those tags
        Integer max = 0;
        String mostTag = "";
        List<String> mostTags = new ArrayList<>();

        while (mostTags.size() < 3){
            for(String key: tags.keySet()){
                if (tags.get(key) > max){
                    max=tags.get(key);
                    mostTag = key;
                }
            }
            mostTags.add(mostTag);
            tags.remove(mostTag);
            max = 0;
        }
        System.out.println(mostTags);



        //get in total 5 items that have at least one of these tags in the post database
        Recommendation recommendation = new Recommendation(postDsGateway.findPosts(mostTags));


        if (recommendation.getPosts().size() == 0){
            return recommendationOutputBoundry.prepareFailView("There is no recommendation for you now!");
        }
        RecommendationResponseModel recommendationResponseModel = new RecommendationResponseModel(recommendation);
        return recommendationOutputBoundry.prepareRecommendationView(recommendationResponseModel);
    }


}
