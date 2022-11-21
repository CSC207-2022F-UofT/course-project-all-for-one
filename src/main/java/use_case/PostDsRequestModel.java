package use_case;

public class PostDsRequestModel {
    private final String username;
    private final String title;
    private final String description;

    private final String status;

    private final double price;

    private final String[] tags;


    public PostDsRequestModel(String username, String title, String description, String status, double price, String[] tags){
        this.username = username;
        this.title = title;
        this.description = description;
        this.status = status;
        this.price = price;
        this.tags = tags;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public String[] getTags() {
        return tags;
    }
}
