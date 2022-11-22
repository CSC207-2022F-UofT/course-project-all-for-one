package use_case;

import Entity.Account;
import Entity.Post;

public class TradeRequestModel {

    public Post Post;

    public String CreationTime;

    public String Name;

    public String Address;

    public String PhoneNumber;

    private Account Buyer;

    private Account Seller;



    public TradeRequestModel(Post post, String creationTime,
                             String name, String address, String phoneNumber, Account buyer, Account seller) {
        this.Post = post;
        this.CreationTime = creationTime;
        this.Name = name;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.Buyer = buyer;
        this.Seller = seller;
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
}
