package entities;

public class OrderFactory {

    public static Order create(Post post, double finalPrice, String creationTime,
                               String name, String address, String phoneNumber, String shipmentStatus) {
        return new Order(post, creationTime, name, address, phoneNumber, shipmentStatus);
    }
}
