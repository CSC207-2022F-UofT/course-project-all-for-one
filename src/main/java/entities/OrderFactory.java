package entities;

public class OrderFactory {

    public static Order create(Post post, String creationTime, String name, String address, String phoneNumber,
                               String shipmentStatus, String buyerUsername, String sellerUsername) {
        return new Order(post, creationTime, name, address, phoneNumber, shipmentStatus, buyerUsername, sellerUsername);
    }
}
