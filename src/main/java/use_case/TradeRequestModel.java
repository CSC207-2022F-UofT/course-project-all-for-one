package use_case;

import entities.Account;
import entities.Post;

public class TradeRequestModel {

    public Post Post;

    public String CreationTime;

    public String Name;

    public String Address;

    public String PhoneNumber;

    private String BuyerUsername;

    private String SellerUsername;

    private Account Buyer;

    private Account Seller;



    public TradeRequestModel(Post post, String creationTime,
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

    String getCreationTime() {
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
