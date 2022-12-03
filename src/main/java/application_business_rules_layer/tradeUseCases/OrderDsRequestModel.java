package application_business_rules_layer.tradeUseCases;

import java.util.List;

public class OrderDsRequestModel {

    private final String Title;

    private final String CreationTime;

    private final double Price;

    private final String Name;

    private final String Address;

    private final String PhoneNumber;

    private String ShipmentStatus;

    private final String BuyerUsername;

    private final String SellerUsername;

    private final List<String> Tags;

    public OrderDsRequestModel(String title, String creationTime, double price, String name, String address,
                               String phoneNumber, String shipmentStatus, String buyerUsername, String sellerUsername, List<String> tags) {
        Title = title;
        CreationTime = creationTime;
        Price = price;
        Name = name;
        Address = address;
        PhoneNumber = phoneNumber;
        ShipmentStatus = shipmentStatus;
        BuyerUsername = buyerUsername;
        SellerUsername = sellerUsername;
        Tags = tags;
    }

    /**
     *
     * @return the title of the order to be saved in database
     */
    public String getTitle() {
        return Title;
    }

    /**
     *
     * @return the creation time of the order to be saved in database
     */
    public String getCreationTime() {
        return CreationTime;
    }

    /**
     *
     * @return the name of the shipment information of the order to be saved in database
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @return the address of the shipment information of the order to be saved in database
     */
    public String getAddress() {
        return Address;
    }

    /**
     *
     * @return the phone number of the shipment information of the order to be saved in database
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     *
     * @return the shipment status of the order to be saved in database
     */
    public String getShipmentStatus() {
        return ShipmentStatus;
    }

    /**
     *
     * @return the transaction value of the order to be saved in database
     */
    public double getPrice() {
        return Price;
    }

    /**
     *
     * @return the username of the buyer of the order to be saved in database
     */
    public String getBuyerUsername() {
        return BuyerUsername;
    }

    /**
     *
     * @return the username of the seller of the order to be saved in database
     */
    public String getSellerUsername() {
        return SellerUsername;
    }

    /**
     *
     * @return the list of tags of the order to be saved in database
     */
    public List<String> getTags() {
        return Tags;
    }
}
