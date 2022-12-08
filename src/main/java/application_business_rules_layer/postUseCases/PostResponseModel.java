package application_business_rules_layer.postUseCases;

import enterprise_business_rules_layer.postEntities.Post;

public class PostResponseModel {

    Post post;
    String creationTime;

    public PostResponseModel(Post post, String creationTime) {
        this.post = post;
        this.creationTime = creationTime;
    }

    /**
     *
     * @return the creation time in the request model object
     */
    public String getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @ set the creation time in the request model object
     */
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
    public Post getPost(){return this.post;}
}

