package enterprise_business_rules_layer.postEntities;

import java.util.ArrayList;


public class Post {
    private final String Username;
    private final String Title;
    private final String Description;
    private String Status;
    private final String Price;
    private final ArrayList<String> Tags;
    private final String Id;

    /**
     *
     * @param input_username username of the acting user
     * @param input_title user's input title of the post
     * @param input_description user's input description of the posting item
     * @param input_price user's input price of the posting item
     * @param tags user's input tags of the posting item
     */

    public Post(String input_username, String input_title, String input_description, String input_price, ArrayList<String> tags){
        this.Username = input_username;
        this.Title = input_title;
        this.Description = input_description;
        this.Price = input_price;
        this.Status = "Active";
        this.Tags = tags;
        this.Id = String.valueOf(this.hashCode());
    }

    public Post(String input_username, String input_title, String input_description, String input_price, ArrayList<String> tags, String input_id){
        this.Username = input_username;
        this.Title = input_title;
        this.Description = input_description;
        this.Price = input_price;
        this.Status = "Active";
        this.Tags = tags;
        this.Id = input_id;
    }

    public String getTitle(){
        return this.Title;
    }
    public String getUsername(){
        return this.Username;
    }
    public String getDescription(){
        return this.Description;
    }

    public String getId() {return this.Id;}

    public ArrayList<String> getTags() {
        return this.Tags;
    }
    public String getTagsString() {
        return this.Tags.toString();
    }

    public String getStatus(){
        return this.Status;
    }
    public String getPrice(){
        return this.Price;
    }

    public boolean is_valid(){
        Criteria criteria = new Criteria();
        Suggestion suggestion = criteria.evaluatePost(this);
        return suggestion.suggestion == null;
    }

    public void setSold(){
        this.Status = "Sold";
    }


}

