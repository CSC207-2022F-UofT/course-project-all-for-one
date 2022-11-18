package entity;

public class Order {

    private final Post Post;

    private final String CreationTime;

    private final String Name;

    private final String Address;

    private final String PhoneNumber;

    private String ShipmentStatus;


    Order(Post post, String creationTime, String name, String address, String phoneNumber,
          String shipmentStatus) {
        this.Post = post;
        this.CreationTime = creationTime;
        this.Name = name;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.ShipmentStatus = shipmentStatus;
    }

    public Post getPost() {
        return this.Post;
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

    public String getShipmentStatus() {
        return this.ShipmentStatus;
    }
}
