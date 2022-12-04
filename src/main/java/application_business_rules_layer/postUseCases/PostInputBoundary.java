package application_business_rules_layer.postUseCases;

public interface PostInputBoundary {
    /**
     *
     * @param requestModel the PostRequestModel that serves as the input needed processing the post creation
     * @return the PostResponseModel object that is the output after processing the post creation
     */
    PostResponseModel create(PostRequestModel requestModel);

}
