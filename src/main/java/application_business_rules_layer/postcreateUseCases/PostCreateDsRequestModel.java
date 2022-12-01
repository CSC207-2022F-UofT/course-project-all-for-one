package application_business_rules_layer.postcreateUseCases;

import java.time.LocalDateTime;
import java.util.ArrayList;

// Use case layer

public class PostCreateDsRequestModel {
    private String Username;

    private String Title;
    private String Description;
    private String Status;
    private double Price;
    private ArrayList<String> Tags;
    private final LocalDateTime creationTime;

    private String Id;

    public PostCreateDsRequestModel(String input_username, String input_title, String input_description, double input_price, ArrayList<String> tags, LocalDateTime time){
        this.Username = input_username;
        this.Title = input_title;
        this.Description = input_description;
        this.Price = input_price;
        this.Status = "Active";
        this.Tags = tags;
        this.creationTime = time;
        this.Id = String.valueOf(this.hashCode());

    }
    public void reviseDescription(String revise_description){
        this.Description = revise_description;
    }
    public void reviseTitle(String revise_title){this.Title = revise_title;}

    public void revisePrice(double revise_price){
        this.Price = revise_price;
    }
    public String getUsername(){return this.Username;}
    public void reviseUsername(String revise_username){this.Username = revise_username;}
    public String getTitle(){
        return this.Title;
    }
    public String getDescription(){
        return this.Description;
    }

    public String getId() {return this.Id;}

    public ArrayList<String> getTags() {
        return this.Tags;
    }

    public String getStatus(){
        return this.Status;
    }
    public double getPrice(){
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
