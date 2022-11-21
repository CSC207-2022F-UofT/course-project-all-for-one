import entity.Post;
import entity.Recommendation;
import use_case.RecommendationResponseModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CodeTest {
    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("iphone13", "good", 1300);
        Post post2 = new Post("ipad pro", "take notes", 999);
        Post post3 = new Post("airpods", "good sounding", 230);
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        Recommendation recommendation1 = new Recommendation(posts);
        RecommendationResponseModel responseModel = new RecommendationResponseModel(recommendation1);

        System.out.println(Array.getLength(responseModel.getRecommendation().getPosts()) < 3);
    }
}
