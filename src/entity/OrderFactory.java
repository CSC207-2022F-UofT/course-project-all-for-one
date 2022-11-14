package entity;

public class OrderFactory {

    public static Order create(String orderNumber, String title, String price,
                               String creationTime, String name, String address, String phoneNumber) {
        return new Order(orderNumber, title, price, creationTime, name, address, phoneNumber);
    }
}
