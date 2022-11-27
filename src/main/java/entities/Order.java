package entities;

public class Order {

    private final Post Post;

    private final String CreationTime;

    private final String Name;

    private final String Address;

    private final String PhoneNumber;

    private String ShipmentStatus;

    private final String BuyerUsername;

    private final String SellerUsername;


    Order(Post post, String creationTime, String name, String address, String phoneNumber,
          String shipmentStatus, String buyerUsername, String sellerUsername) {
        Post = post;
        CreationTime = creationTime;
        Name = name;
        Address = address;
        PhoneNumber = phoneNumber;
        ShipmentStatus = shipmentStatus;
        BuyerUsername = buyerUsername;
        SellerUsername = sellerUsername;
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

    public String getCreationTime() {
        return this.CreationTime;
    }

    public String getBuyerUsername() {
        return BuyerUsername;
    }

    public String getSellerUsername() {
        return SellerUsername;
    }
}
