package framworks_drivers_layer.dataAccess;

import application_business_rules_layer.postUseCases.PostDsRequestModel;
import application_business_rules_layer.postUseCases.PostDsGateway;
import enterprise_business_rules_layer.postEntities.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryPost implements PostDsGateway {

    final private Map<String, PostDsRequestModel> posts = new HashMap<>();


    /**
     * @param requestModel the data to save
     */
    @Override
    public void save(PostDsRequestModel requestModel) {
        System.out.println("Save " + requestModel.getUsername() + ": " + requestModel.getTitle());
        posts.put(requestModel.getUsername(), requestModel);
    }

    /**
     * @param Tags list of tags that are used to find Post object with these tags
     * @return return a list of Post objects of length at most 30 that contain at least one tag in Tags
     */
    @Override
    public List<Post> findPosts(List<String> Tags) {
        List<Post> posts = new ArrayList<>();
        for(String tag : Tags){
            for(PostDsRequestModel postDsRequestModel: this.posts.values()){
                if (postDsRequestModel.getTags().contains(tag) && posts.size() < 30){
                    posts.add(new Post(postDsRequestModel.getUsername(),
                            postDsRequestModel.getTitle(), postDsRequestModel.getDescription(),
                            postDsRequestModel.getPrice(), postDsRequestModel.getTags()));
                }
            }
        }
        return posts;
    }

    /**
     * @param keyword
     * @return
     */
    @Override
    public List<Post> findPostsWithKeyword(String keyword) {
        List<Post> posts = new ArrayList<>();
        for(PostDsRequestModel postDsRequestModel: this.posts.values()){
            if (postDsRequestModel.getTags().contains(keyword) && posts.size() < 30){
                posts.add(new Post(postDsRequestModel.getUsername(),
                        postDsRequestModel.getTitle(), postDsRequestModel.getDescription(),
                        postDsRequestModel.getPrice(), postDsRequestModel.getTags()));
            }
        }
        return posts;
    }
}