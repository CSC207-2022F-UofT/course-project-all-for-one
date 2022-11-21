package entity;

import java.util.ArrayList;

public class Post {
    private final String Username;
    private final String Title;
    private final String Description;
    private final String Status;
    private final double Price;
    private final ArrayList<String> Tags;

    Post(String input_username, String input_title, String input_description, double input_price, ArrayList<String> tags){
        this.Username = input_username;
        this.Title = input_title;
        this.Description = input_description;
        this.Price = input_price;
        this.Status = "Active";
        this.Tags = tags;
    }

    public String get_title(){
        return this.Title;
    }
    public String get_username(){
        return this.Username;
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

    public boolean is_valid(){
        Criteria criteria = new Criteria();
        Suggestion suggestion = criteria.evaluatePost(this);
        return suggestion.suggestion == null;
    }


}

