package use_case;

public class OrderDsRequestModel {

    private final String Title;

    private final String CreationTime;

    private String Name;

    private String Address;

    private String PhoneNumber;

    private String ShipmentStatus;

    public OrderDsRequestModel(String title, String creationTime, String name, String address,
                               String phoneNumber, String shipmentStatus) {
        this.Title = title;
        this.CreationTime = creationTime;
        this.Name = name;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.ShipmentStatus = shipmentStatus;
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
}
