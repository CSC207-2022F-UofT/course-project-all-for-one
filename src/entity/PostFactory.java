package entity;

public class PostFactory {
    public Post create(String input_title, String input_description, double input_price, String [] tags){
        Post post = new Post(input_title, input_description, input_price, tags);
        return post;
    }
}
