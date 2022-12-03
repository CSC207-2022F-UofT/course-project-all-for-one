package application_business_rules_layer.tradeUseCases;

import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.postEntities.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TradeRequestModel {

    private final Post Post;

    private final LocalDateTime CreationTime;

    private final String Name;

    private final String Address;

    private final String PhoneNumber;

    private final String BuyerUsername;



    public TradeRequestModel(Post post, LocalDateTime creationTime, String name,  String address, String phoneNumber,
                              String buyerUsername) {
        Post = post;
        CreationTime = creationTime;
        Name = name;
        Address = address;
        PhoneNumber = phoneNumber;
        BuyerUsername = buyerUsername;
    }

    /**
     *
     * @return the Post object to be processed
     */
    Post getPost() {
        return this.Post;
    }

    /**
     *
     * @return the name of the shipment information to be processed
     */
    String getName() {
        return this.Name;
    }

    /**
     *
     * @return the address of the shipment information to be processed
     */
    String getAddress() {
        return this.Address;
    }

    /**
     *
     * @return the phone number of the shipment information to be processed
     */
    String getPhoneNumber() {
        return this.PhoneNumber;
    }

    /**
     *
     * @return the username of the buyer to be processed
     */
    public String getBuyerUsername() {
        return BuyerUsername;
    }

    /**
     *
     * @return the username of the seller to be processed
     */
    public String getSellerUsername() {
        return Post.getUsername();
    }

    /**
     *
     * @return the String form of the creation time of the transaction to be processed
     */
    public String getCreationTimeString() {
        return this.CreationTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }
}
