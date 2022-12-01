package application_business_rules_layer.postcreateUseCases;

import enterprise_business_rules_layer.postEntities.Post;

import java.util.List;

public interface PostCreateDsGateway {
    void save(PostCreateDsRequestModel requestModel);

    /**
     *
     * @param Tags list of tags that are used to find Post object with these tags
     * @return return a list of Post objects of length at most 30 that contain at least one tag in Tags
     */
    List<Post> findPosts(List<String> Tags);

    List<Post> findPostsWithKeyword(String keyword);
}
