package use_case;

// Use case layer

import java.util.ArrayList;
import java.util.Objects;

public class PostRequestModel {
    private String Username;
    private String Title;
    private String Description;
    private String Status;
    private double Price;
    private ArrayList<String> Tags;

    public PostRequestModel(String input_username, String input_title, String input_description, double input_price, ArrayList<String> tags){
        this.Username = input_username;
        this.Title = input_title;
        this.Description = input_description;
        this.Price = input_price;
        this.Status = "Active";
        this.Tags = tags;

    }

    public void Revise_description(String revise_description){
        this.Description = revise_description;
    }

    public void Revise_price(double revise_price){
        this.Price = revise_price;
    }

    public String get_username(){return this.Username;}
    public String get_title(){
        return this.Title;
    }
    public String get_description(){
        return this.Description;
    }

    public ArrayList<String> get_tags() {
        return this.Tags;
    }

    public String get_status(){
        return this.Status;
    }
    public double get_price(){
        return this.Price;
    }

    public void add_tags(String tag) {
        this.Tags.add(tag);
    }

    public void delete_tags(String tag) {
        this.Tags.remove(tag);
    }
}
