package entities;

public interface Order {
    Post getPost();

    String getName();

    String getAddress();

    String getPhoneNumber();

    String getShipmentStatus();

    String getCreationTime();

    String getBuyerUsername();

    String getSellerUsername();
}
