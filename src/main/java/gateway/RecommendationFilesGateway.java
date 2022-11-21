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

    /**
     *
     * @param Tags list of tags that are used to find Post object with these tags
     * @param username username of the user that is acting
     * @return return a list of Post objects of length at most 30 that contain at least one tag in Tags
     */
    @Override
    // return 30 posts that contain at least one of tags and is not owned by username
    public List<Post> findPosts(List<String> Tags, String username) {
        return null;
    }

    /**
     *
     * @param username username of the user that is acting
     * @return the purchase history object that is owned by the user with username in database
     */
    @Override
    public PurchaseHistory getPurchaseHistory(String username) {
        return null;
    }

    /**
     *
     * @param username username of the user that is acting
     * @return the browsing history object that is owned by the user with username in database
     */
    @Override
    public BrowsingHistory getBrowsingHistory(String username) {
        return null;
    }
}
