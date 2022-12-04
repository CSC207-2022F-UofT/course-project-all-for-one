package application_business_rules_layer.postUseCases;

import enterprise_business_rules_layer.postEntities.Post;

import java.util.List;

public interface PostDsGateway {
    /**
     *
     * @param requestModel a request model that is used to store the information needed to request creating a post
     * @ save the required information to posts' database
     */
    void save(PostDsRequestModel requestModel);
    /**
     *
     * @param id the id of the post that is required to delete
     * @ delete the required information to posts' database
     */
    void delete(String id);

    /**
     *
     * @param Tags list of tags that are used to find Post object with these tags
     * @return return a list of Post objects of length at most 30 that contain at least one tag in Tags
     */
    List<Post> findPosts(List<String> Tags);

    List<Post> findPostsWithKeyword(String keyword);

    List<Post> allPosts(String username);
}
