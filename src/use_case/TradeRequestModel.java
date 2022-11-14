package use_case;

public class TradeRequestModel {

    public String PostNumber;

    public String PostTitle;

    public String FinalPrice;

    public String CreationTime;

    public String Name;

    public String Address;

    public String PhoneNumber;



    public TradeRequestModel(String postNumber, String postTitle, String finalPrice, String creationTime,
                             String name, String address, String phoneNumber) {
        this.PostNumber = postNumber;
        this.PostTitle = postTitle;
        this.FinalPrice = finalPrice;
        this.CreationTime = creationTime;
        this.Name = name;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
    }

    String getPostNumber() {
        return this.PostNumber;
    }
    String getPostTitle() {
        return this.PostTitle;
    }

    String getFinalPrice() {
        return this.FinalPrice;
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
}
