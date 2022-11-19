package entity;

import java.util.ArrayList;
import java.util.List;

public class Recommendation {

    private List<Post> Posts;

    public Recommendation(){ this.Posts = new ArrayList<>(); }
    public Recommendation(List<Post> Posts){
        this.Posts = Posts;
    }

    public List<Post> getPosts() {
        return Posts;
    }

    public void addRecommendation(Post post){
        this.Posts.add(post);
    }
}
