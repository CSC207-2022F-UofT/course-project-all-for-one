package use_case;

public class TradeRequestModel {

    private String number;

    public TradeRequestModel(String number) {
        this.number = number;
    }

    String getOrder() {return number;}
}
