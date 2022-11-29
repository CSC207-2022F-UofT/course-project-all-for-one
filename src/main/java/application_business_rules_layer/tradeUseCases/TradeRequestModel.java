package application_business_rules_layer.tradeUseCases;

import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.postEntities.Post;

import java.time.LocalDateTime;

public class TradeRequestModel {

    public Post Post;

    public LocalDateTime CreationTime;

    public String Name;

    public String Address;

    public String PhoneNumber;

    private String BuyerUsername;

    private String SellerUsername;

    private Account Buyer;

    private Account Seller;



    public TradeRequestModel(Post post, LocalDateTime creationTime,
                             String name, String address, String phoneNumber, String buyerUsername,
                             String sellerUsername, Account buyer, Account seller) {
        Post = post;
        CreationTime = creationTime;
        Name = name;
        Address = address;
        PhoneNumber = phoneNumber;
        BuyerUsername = buyerUsername;
        SellerUsername = sellerUsername;
        Buyer = buyer;
        Seller = seller;
    }

    Post getPost() {
        return this.Post;
    }

    LocalDateTime getCreationTime() {
        return this.CreationTime;
    }

    String getName() {
        return this.Name;
    }

    String getAddress() {
        return this.Address;
    }

    String getPhoneNumber() {
        return this.PhoneNumber;
    }

    Account getBuyer() {
        return this.Buyer;
    }

    Account getSeller() {
        return this.Seller;
    }

    public String getBuyerUsername() {
        return BuyerUsername;
    }

    public String getSellerUsername() {
        return SellerUsername;
    }
}
