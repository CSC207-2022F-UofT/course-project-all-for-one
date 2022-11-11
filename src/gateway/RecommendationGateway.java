package gateway;

import entity.Post;

import java.util.List;

public interface RecommendationGateway {

    List<Post> findPosts(List<String> Tags);
}
