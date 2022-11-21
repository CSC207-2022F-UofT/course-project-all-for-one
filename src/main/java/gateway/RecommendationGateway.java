package gateway;


import entity.BrowsingHistory;
import entity.Post;
import entity.PurchaseHistory;

import java.util.List;

public interface RecommendationGateway {

    List<Post> findPosts(List<String> Tags, String username);

    PurchaseHistory getPurchaseHistory(String username);

    BrowsingHistory getBrowsingHistory(String username);
}
