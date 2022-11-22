package entities;

import java.util.ArrayList;
import java.util.List;

public class Post {
    String Title;
    String Description;
    private String Status;
    private double price;
    private String [] tags = {};

    public Post(String input_title, String input_description, double input_price){
        this.Title = input_title;
        this.Description = input_description;
        this.price = input_price;
        this.Status = "Active";
        this.tags = new String[]{};
    }

    public String get_Title(){
        return this.Title;
    }

    public String get_status(){
        return this.Status;
    }

}
