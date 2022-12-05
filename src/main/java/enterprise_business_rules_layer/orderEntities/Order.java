package enterprise_business_rules_layer.orderEntities;

import enterprise_business_rules_layer.postEntities.Post;

public interface Order {

    /**
     *
     * @return the Post object of the order
     */
    Post getPost();

    /**
     *
     * @return the name of the shipment information of the order
     */
    String getName();

    /**
     *
     * @return the address of the shipment information of the order
     */
    String getAddress();

    /**
     *
     * @return the phone number of the shipment information of the order
     */
    String getPhoneNumber();

    /**
     *
     * @return the shipment status of the order
     */
    String getShipmentStatus();

    /**
     *
     * @return the creation time of the order
     */
    String getCreationTime();

    /**
     *
     * @return the username of the buyer of the order
     */
    String getBuyerUsername();

    /**
     *
     * @return the username of the seller of the order
     */
    String getSellerUsername();

    /**
     *
     * @return the ID of the order
     */
    String getID();

}
