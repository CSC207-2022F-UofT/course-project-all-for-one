package entity;

import java.util.Objects;

public class Post {
    String title;
    String description;
    private String status;
    private double price;
    private String [] tags = {};

    public Post(String input_title, String input_description, double input_price){
        this.title = input_title;
        this.description = input_description;
        this.price = input_price;
        this.status = "Active";
        this.tags = new String[]{};
    }

    public void Revise_description(String revise_description){
        this.description = revise_description;
    }

    public void Revise_price(double revise_price){
        this.price = revise_price;
    }

    public double get_price(){
        return this.price;
    }

    public void solding_post(){
        this.status = "Sold";
    }

    public void pending_post(){
        this.status = "Pending";
    }

    public void activating_post(){
        this.status = "Active";
    }

    public String get_status(){
        return this.status;
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

    public String[] getTags() {
        return tags;
    }

    public String getTitle(){ return title; }

    public String getDescription() {
        return description;
    }
}

