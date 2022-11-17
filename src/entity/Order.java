package entity;

public class Order {

    private final Post Post;

    private final double FinalPrice;

    private final String CreationTime;

    private final String Name;

    private final String Address;

    private final String PhoneNumber;


    Order(Post post, double finalPrice, String creationTime, String name, String address, String phoneNumber) {
        this.Post = post;
        this.FinalPrice = finalPrice;
        this.CreationTime = creationTime;
        this.Name = name;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
    }

    public Post getPost() {
        return this.Post;
    }

    public double getFinalPrice() {
        return this.FinalPrice;
    }

    public String getName() {
        return this.Name;
    }

    public String getAddress() {
        return this.Address;
    }

    public String getPhoneNumber() {
        return this.Address;
    }
}
