package gateway;


import entity.BrowsingHistory;
import entity.Post;
import entity.PurchaseHistory;

import java.util.List;

public interface RecommendationGateway {

    /**
     *
     * @param Tags list of tags that are used to find Post object with these tags
     * @param username username of the user that is acting
     * @return return a list of Post objects of length at most 30 that contain at least one tag in Tags
     */
    List<Post> findPosts(List<String> Tags, String username);

    /**
     *
     * @param username username of the user that is acting
     * @return the purchase history object that is owned by the user with username in database
     */

    PurchaseHistory getPurchaseHistory(String username);

    /**
     *
     * @param username username of the user that is acting
     * @return the browsing history object that is owned by the user with username in database
     */
    BrowsingHistory getBrowsingHistory(String username);
}
