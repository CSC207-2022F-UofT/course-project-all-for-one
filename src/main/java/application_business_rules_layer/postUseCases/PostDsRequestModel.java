package application_business_rules_layer.postUseCases;

import java.time.LocalDateTime;
import java.util.ArrayList;

// Use case layer

public class PostDsRequestModel {
    private String Username;

    private String Title;
    private String Description;
    private String Status;
    private String Price;
    private ArrayList<String> Tags;
    private final LocalDateTime creationTime;

    private String Id;

    /**
     *
     * @param input_username username of the acting user
     * @param input_title user's input title of the post
     * @param input_description user's input description of the posting item
     * @param input_price user's input price of the posting item
     * @param tags user's input tags of the posting item
     * @param inputId the id restored when created
     * @param time the creation time
     */
    public PostDsRequestModel(String input_username, String input_title, String input_description, String input_price, ArrayList<String> tags, LocalDateTime time, String inputId){
        this.Username = input_username;
        this.Title = input_title;
        this.Description = input_description;
        this.Price = input_price;
        this.Status = "Active";
        this.Tags = tags;
        this.creationTime = time;
        this.Id = inputId;

    }
    public void reviseDescription(String revise_description){
        this.Description = revise_description;
    }
    public void reviseTitle(String revise_title){this.Title = revise_title;}

    public void revisePrice(String revise_price){
        this.Price = revise_price;
    }

    /**
     *
     * @return the username
     */
    public String getUsername(){return this.Username;}
    public void reviseUsername(String revise_username){this.Username = revise_username;}

    /**
     *
     * @return the title
     */
    public String getTitle(){
        return this.Title;
    }

    /**
     *
     * @return the description
     */
    public String getDescription(){
        return this.Description;
    }

    /**
     *
     * @return the id
     */

    public String getId() {return this.Id;}

    /**
     *
     * @return the list of tags
     */

    public ArrayList<String> getTags() {
        return this.Tags;
    }

    /**
     *
     * @return the status
     */
    public String getStatus(){
        return this.Status;
    }
    public String getPrice(){
        return this.Price;
    }

    public void addTags(String tag) {
        this.Tags.add(tag);
    }

    public void deleteTags(String tag) {
        this.Tags.remove(tag);
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }


}
