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

    public String getTitle() {
        return Title;
    }

    public String getCreationTime() {
        return CreationTime;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getShipmentStatus() {
        return ShipmentStatus;
    }

    public double getPrice() {
        return Price;
    }

    public String getBuyerUsername() {
        return BuyerUsername;
    }

    public String getSellerUsername() {
        return SellerUsername;
    }

    public List<String> getTags() {
        return Tags;
    }
}
