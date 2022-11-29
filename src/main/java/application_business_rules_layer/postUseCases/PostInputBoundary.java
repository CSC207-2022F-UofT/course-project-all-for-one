package application_business_rules_layer.postUseCases;

public interface PostInputBoundary {
    PostResponseModel create(PostRequestModel requestModel);
}
