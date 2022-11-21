package entity;

import java.util.ArrayList;
import java.util.List;

public class Recommendation {

    private List<Post> Posts;

    /**
     *  instantiate a Recommendation object
     */
    public Recommendation(){ this.Posts = new ArrayList<>(); }

    /**
     *
     * @param Posts list of Post objects that are used to instantiate a Recommendation object
     */
    public Recommendation(List<Post> Posts){
        this.Posts = Posts;
    }

    /**
     *
     * @return the list of Posts that a Recommendation object has
     */
    public List<Post> getPosts() {
        return Posts;
    }

    /**
     *
     * @param post add the Post object to the Recommendation object
     */
    public void addRecommendation(Post post){
        this.Posts.add(post);
    }
}
