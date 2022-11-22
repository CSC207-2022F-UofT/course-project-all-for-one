package entity;

import java.util.ArrayList;

public class PostFactory {
    public Post create(String input_username, String input_title, String input_description, double input_price, ArrayList<String> tags){
        return new Post(input_username, input_title, input_description, input_price, tags);
    }
}
