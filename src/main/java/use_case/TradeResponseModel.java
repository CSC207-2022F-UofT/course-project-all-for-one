package use_case;

public class TradeResponseModel {
    String Success;

    String TradeTime;

    public TradeResponseModel(String success, String creationTime) {
        this.Success = success;
        this.TradeTime = creationTime;
    }

    public String getSuccess() {return this.Success;}

    public String getCreationTime() {return this.TradeTime;}
}
