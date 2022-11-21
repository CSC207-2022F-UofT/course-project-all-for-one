package gateway;

import entity.BrowsingHistory;
import entity.Post;
import entity.PurchaseHistory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RecommendationFilesGateway implements RecommendationGateway{
    private File csvfile;
    public RecommendationFilesGateway(String filePath) throws IOException{
        this.csvfile = new File(filePath);
    }

    @Override
    // return 30 posts that contain at least one of tags and is not owned by username
    public List<Post> findPosts(List<String> Tags, String username) {
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
