package application_business_rules_layer.postcreateUseCases;

public class PostCreateResponseModel {

    String result;
    String creationTime;

    public PostCreateResponseModel(String result, String creationTime) {
        this.result = result;
        this.creationTime = creationTime;
    }

    public String getLogin() {
        return result;
    }

    public void setLogin(String result) {
        this.result = result;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}

