package gateway;


import entities.Post;

import java.util.List;

public interface RecommendationGateway {

    /**
     *
     * @param Tags list of tags that are used to find Post object with these tags
     * @return return a list of Post objects of length at most 30 that contain at least one tag in Tags
     */
    List<Post> findPosts(List<String> Tags);

    /**
     *
     * @param username username of the user that is acting
     * @return the purchase history object that is owned by the user with username in database
     */

    List<String> getPurchaseHistoryTags(String username);

    /**
     *
     * @param username username of the user that is acting
     * @return the browsing history object that is owned by the user with username in database
     */
    List<String> getBrowsingHistoryTags(String username);
}
