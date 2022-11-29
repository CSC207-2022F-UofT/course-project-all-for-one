package enterprise_business_rules_layer.orderEntities;

import enterprise_business_rules_layer.postEntities.Post;

public interface OrderFactory {
    Order create(Post post, String creationTime, String name, String address, String phoneNumber,
                 String shipmentStatus, String buyerUsername, String sellerUsername);
}
