package use_case;

import java.time.LocalDateTime;
import java.util.Objects;

// Use case layer

public class PostDsRequestModel {

    private String Title;
    private String Description;
    private String Status;
    private double Price;
    private String [] Tags;
    private final LocalDateTime creationTime;

    public PostDsRequestModel(String input_title, String input_description, double input_price, String [] tags, LocalDateTime time){
        this.Title = input_title;
        this.Description = input_description;
        this.Price = input_price;
        this.Status = "Active";
        this.Tags = tags;
        this.creationTime = time;

    }
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

    public String[] get_tags() {
        return this.Tags;
    }

    public String get_status(){
        return this.Status;
    }
    public double get_price(){
        return this.Price;
    }

    public void add_tags(String tag) {
        String[] arrNew = new String[this.Tags.length + 1];
        int i;
        for (i = 0; i < this.Tags.length; i++) {
            arrNew[i] = this.Tags[i];
        }
        arrNew[i] = tag;
        this.Tags = arrNew;
    }

    public void delete_tags(String tag) {
        String[] arrNew = new String[this.Tags.length - 1];
        for(int i = 0, k = 0; i < this.Tags.length; i++){
            if(!Objects.equals(this.Tags[i], tag)){
                arrNew[k] = this.Tags[i];
                k++;
            }
        }
        this.Tags = arrNew;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }


}
