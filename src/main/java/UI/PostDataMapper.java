package UI;

import java.time.LocalDateTime;
import java.util.ArrayList;

// Frameworks/Drivers layer

/**
 * Used by Spring to know what data to maintain. It's used by JpaRepository,
 * Spring's root of the programmer-written persistence classes mapping data to =
 * storage.
 */
class PostDataMapper {
    String Username;
    String Title;
    String Description;
    String Status;
    double Price;
    ArrayList<String> Tags;
    LocalDateTime creationTime;

    public PostDataMapper(){

    }

    public PostDataMapper(String input_username, String input_title, String input_description, double input_price, ArrayList<String> tags, LocalDateTime time){
        super();
        this.Username = input_username;
        this.Title = input_title;
        this.Description = input_description;
        this.Price = input_price;
        this.Status = "Active";
        this.Tags = tags;
        this.creationTime = time;

    }
    public String get_username(){return this.Username;}
    public void Revise_username(String revise_username){this.Username = revise_username;}
    public void Revise_title(String revise_title){this.Title = revise_title;}
    public void Revise_description(String revise_description){
        this.Description = revise_description;
    }

    public void Revise_price(double revise_price){
        this.Price = revise_price;
    }

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

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

}

