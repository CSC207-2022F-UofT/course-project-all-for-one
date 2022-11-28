package entities;

public class PhysicalOrderFactory implements OrderFactory {

    @Override
    public PhysicalOrder create(Post post, String creationTime, String name, String address, String phoneNumber,
                                       String shipmentStatus, String buyerUsername, String sellerUsername) {
        return new PhysicalOrder(post, creationTime, name, address, phoneNumber, shipmentStatus, buyerUsername, sellerUsername);
    }
}
