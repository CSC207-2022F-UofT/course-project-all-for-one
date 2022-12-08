package application_business_rules_layer.postUseCases;

// Use case layer

import java.util.ArrayList;

public class PostRequestModel {
    private String Username;
    private String Title;
    private String Description;
    private String Status;
    private String Price;
    private ArrayList<String> Tags;
    private String Id;

    /**
     *
     * @param input_username username of the acting user
     * @param input_title user's input title of the post
     * @param input_description user's input description of the posting item
     * @param input_price user's input price of the posting item
     * @param tags user's input tags of the posting item
     */

    public PostRequestModel(String input_username, String input_title, String input_description, String input_price, ArrayList<String> tags){
        this.Username = input_username;
        this.Title = input_title;
        this.Description = input_description;
        this.Price = input_price;
        this.Status = "Active";
        this.Tags = tags;
        this.Id = String.valueOf(this.hashCode());

    }

    public void Revise_description(String revise_description){
        this.Description = revise_description;
    }

    public void Revise_price(String revise_price){
        this.Price = revise_price;
    }

    /**
     *
     * @return the username in the request model object
     */
    public String get_username(){return this.Username;}

    /**
     *
     * @return the title in the request model object
     */
    public String get_title(){
        return this.Title;
    }
    public String get_description(){
        return this.Description;
    }

    public ArrayList<String> get_tags() {
        return this.Tags;
    }

    public String getId() {
        return this.Id;
    }

    public String get_status(){
        return this.Status;
    }
    public String get_price(){
        return this.Price;
    }

    public void add_tags(String tag) {
        this.Tags.add(tag);
    }

    public void delete_tags(String tag) {
        this.Tags.remove(tag);
    }
}
