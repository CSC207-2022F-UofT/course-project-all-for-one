package application_business_rules_layer.postUseCases;

public class PostResponseModel {

    String result;
    String creationTime;

    public PostResponseModel(String result, String creationTime) {
        this.result = result;
        this.creationTime = creationTime;
    }

    /**
     *
     * @return the creation time in the request model object
     */
    public String getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @ set the creation time in the request model object
     */
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}

