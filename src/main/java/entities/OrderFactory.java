package entities;

public interface OrderFactory {
    Order create(Post post, String creationTime, String name, String address, String phoneNumber,
                 String shipmentStatus, String buyerUsername, String sellerUsername);
}
