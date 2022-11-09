package use_case;

public class TradeResponseModel {
    String success;

    String creationTime;

    public TradeResponseModel(String success, String creationTime) {
        this.success = success;
        this.creationTime = creationTime;
    }

    public String getSuccess() {return success;}

    public String getCreationTime() {return creationTime;}
}
