package entity;

public class Order {

    private final String OrderNumber;

    private final String Title;

    private final String Price;

    private final String CreationTime;

    private final String Name;

    private final String Address;

    private final String PhoneNumber;


    Order(String orderNumber, String title, String price, String creationTime, String name, String address, String phoneNumber) {
        this.OrderNumber = orderNumber;
        this.Title = title;
        this.Price = price;
        this.CreationTime = creationTime;
        this.Name = name;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
    }

    public String getOrderNumber() {
        return this.OrderNumber;
    }

    public String getTitle() {
        return this.Title;
    }
    public String getCreationTime() {
        return this.Title;
    }

    public String getPrice() {
        return this.Price;
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
