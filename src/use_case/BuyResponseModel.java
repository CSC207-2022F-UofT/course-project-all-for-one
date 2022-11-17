package use_case;

public class BuyResponseModel {
    String success;

    String creationTime;

    public BuyResponseModel(String success, String creationTime) {
        this.success = success;
        this.creationTime = creationTime;
    }

    public String getSuccess() {return success;}

    public String getCreationTime() {return creationTime;}
}
