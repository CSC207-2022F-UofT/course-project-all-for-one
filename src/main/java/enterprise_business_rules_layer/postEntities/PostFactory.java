package enterprise_business_rules_layer.postEntities;

import java.util.ArrayList;

// A factory of post entities
public class PostFactory {
    public Post create(String input_username, String input_title, String input_description, String input_price, ArrayList<String> tags){
        return new Post(input_username, input_title, input_description, input_price, tags);
    }
}
