package enterprise_business_rules_layer.orderEntities;

import enterprise_business_rules_layer.postEntities.Post;

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
