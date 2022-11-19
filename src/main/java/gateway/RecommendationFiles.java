package gateway;

import entity.BrowsingHistory;
import entity.Post;
import entity.PurchaseHistory;

import java.util.List;

public class RecommendationFiles implements RecommendationGateway{
    @Override
    public List<Post> findPosts(List<String> Tags) {
        return null;
    }

    @Override
    public PurchaseHistory getPurchaseHistory(String username) {
        return null;
    }

    @Override
    public BrowsingHistory getBrowsingHistory(String username) {
        return null;
    }
}
