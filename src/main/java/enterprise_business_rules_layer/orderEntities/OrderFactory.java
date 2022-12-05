package enterprise_business_rules_layer.orderEntities;

import enterprise_business_rules_layer.postEntities.Post;

public interface OrderFactory {

    /**
     *
     * @param post the Post object of the order to create
     * @param creationTime the creation time of the order to create
     * @param name the name of shipment information of the order to create
     * @param address the address of shipment information of the order to create
     * @param phoneNumber the phone number of shipment information of the order to create
     * @param shipmentStatus the shipment status of the order to create
     * @param buyerUsername the username of the buyer of the order to create
     * @param sellerUsername the username of the seller of the order to create
     * @return an Order object
     */
    Order create(Post post, String creationTime, String name, String address, String phoneNumber,
                 String shipmentStatus, String buyerUsername, String sellerUsername);
}
