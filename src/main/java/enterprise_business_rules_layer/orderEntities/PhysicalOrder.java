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

    private final String ID;



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
        this.ID = String.valueOf(this.hashCode());
    }

    /**
     *
     * @return the Post object of the order
     */
    @Override
    public Post getPost() {
        return this.Post;
    }

    /**
     *
     * @return the name of the shipment information of the order
     */
    @Override
    public String getName() {
        return this.Name;
    }

    /**
     *
     * @return the address of the shipment information of the order
     */
    @Override
    public String getAddress() {
        return this.Address;
    }

    /**
     *
     * @return the phone number of the shipment information of the order
     */
    @Override
    public String getPhoneNumber() {
        return this.PhoneNumber;
    }

    /**
     *
     * @return the shipment status of the order
     */
    @Override
    public String getShipmentStatus() {
        return this.ShipmentStatus;
    }

    /**
     *
     * @return the creation time of the order
     */
    @Override
    public String getCreationTime() {
        return this.CreationTime;
    }

    /**
     *
     * @return the username of the buyer of the order
     */
    @Override
    public String getBuyerUsername() {
        return BuyerUsername;
    }

    /**
     *
     * @return the username of the seller of the order
     */
    @Override
    public String getSellerUsername() {
        return SellerUsername;
    }

    /**
     *
     * @return the ID of the order
     */
    public String getID() {
        return ID;
    }
}
