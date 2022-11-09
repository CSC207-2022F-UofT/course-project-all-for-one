package use_case;

public class BuyRequestModel {

    private String number;

    public BuyRequestModel(String number) {
        this.number = number;
    }

    String getOrder() {return number;}
}
