package use_case;

import entities.Post;
import gateway.PostDsRequestModel;

import java.util.List;

public interface PostDsGateway {
    void save(PostDsRequestModel requestModel);

    /**
     *
     * @param Tags list of tags that are used to find Post object with these tags
     * @return return a list of Post objects of length at most 30 that contain at least one tag in Tags
     */
    List<Post> findPosts(List<String> Tags);
}
