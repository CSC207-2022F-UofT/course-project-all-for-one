package entity;

public class OrderFactory {

    public static Order create(Post post, double finalPrice, String creationTime,
                               String name, String address, String phoneNumber) {
        return new Order(post, finalPrice, creationTime, name, address, phoneNumber);
    }
}
