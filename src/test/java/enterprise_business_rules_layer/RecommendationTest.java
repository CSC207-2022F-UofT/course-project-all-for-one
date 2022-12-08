package enterprise_business_rules_layer;

import enterprise_business_rules_layer.postEntities.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class RecommendationTest {


    @Test
    void getPosts() {
        ArrayList<String> tagsOfPost12 = new ArrayList<>();
        tagsOfPost12.add("iphone");
        tagsOfPost12.add("apple");


        Post post1 = new Post("Seller1", "iphone1", "good", "1", tagsOfPost12);
        Post post2 = new Post("Seller2", "iphone2", "good", "1", tagsOfPost12);


        Recommendation recommendation = new Recommendation();
        recommendation.addRecommendation(post1); recommendation.addRecommendation(post2);

        Assertions.assertEquals(recommendation.getPosts().size(), 2);
    }

    @Test
    void addRecommendation() {
        ArrayList<String> tagsOfPost12 = new ArrayList<>();
        tagsOfPost12.add("iphone");
        tagsOfPost12.add("apple");

        Recommendation recommendation = new Recommendation();
        Post post1 = new Post("Seller1", "iphone1", "good", "1", tagsOfPost12);
        recommendation.addRecommendation(post1);
        Assertions.assertEquals(recommendation.getPosts().size(), 1);
        Assertions.assertEquals(recommendation.getPosts().get(0).getTitle(), "iphone1");

    }

}