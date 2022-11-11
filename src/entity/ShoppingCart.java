package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    Map<Post, Integer> Posts;

    public ShoppingCart(){
        this.Posts = new HashMap<>();
    }

    public void remove(Post post){
        this.Posts.remove(post);
    }

    public void modifynumber(Post post, Integer num){
        this.Posts.replace(post, num);
    }

    public Map<Post, Integer> showShoppingcart(){
        return this.Posts;
    }

    public void add(Post post, Integer num){
        this.Posts.put(post, num);
    }
}
