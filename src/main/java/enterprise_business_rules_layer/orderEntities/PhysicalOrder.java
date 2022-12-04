package enterprise_business_rules_layer.orderEntities;

import enterprise_business_rules_layer.postEntities.Post;

public class PhysicalOrder implements Order {

    private final enterprise_business_rules_layer.postEntities.Post Post;

    private final String CreationTime;

    private final String Name;

    private final String Address;

    private final String PhoneNumber;

    private String ShipmentStatus;

    private final String BuyerUsername;

    private final String SellerUsername;



    PhysicalOrder(Post post, String creationTime, String name, String address, String phoneNumber,
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
    @Override
    public Post getPost() {
        return this.Post;
    }

    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public String getAddress() {
        return this.Address;
    }

    @Override
    public String getPhoneNumber() {
        return this.PhoneNumber;
    }

    @Override
    public String getShipmentStatus() {
        return this.ShipmentStatus;
    }

    @Override
    public String getCreationTime() {
        return this.CreationTime;
    }

    @Override
    public String getBuyerUsername() {
        return BuyerUsername;
    }

    @Override
    public String getSellerUsername() {
        return SellerUsername;
    }

}
