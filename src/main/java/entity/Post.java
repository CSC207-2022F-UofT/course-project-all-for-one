package entity;

import java.util.Objects;

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

    public void Revise_description(String revise_description){
        this.Description = revise_description;
    }

    public void Revise_price(double revise_price){
        this.price = revise_price;
    }

    public double get_price(){
        return this.price;
    }

    public void solding_post(){
        this.Status = "Sold";
    }

    public void pending_post(){
        this.Status = "Pending";
    }

    public void activating_post(){
        this.Status = "Active";
    }

    public String getStatus(){
        return this.Status;
    }

    public String getTitle() {
        return this.Title;
    }

    public String getDescription() {
        return Description;
    }

    public void add_tags(String tag) {
        String[] arrNew = new String[this.tags.length + 1];
        int i;
        for (i = 0; i < this.tags.length; i++) {
            arrNew[i] = this.tags[i];
        }
        arrNew[i] = tag;
        this.tags = arrNew;
    }

    public void delete_tags(String tag) {
        String[] arrNew = new String[this.tags.length - 1];
        for(int i=0, k=0; i < this.tags.length; i++){
            if(!Objects.equals(this.tags[i], tag)){
                arrNew[k] = this.tags[i];
                k++;
            }
        }
        this.tags = arrNew;
    }
}

