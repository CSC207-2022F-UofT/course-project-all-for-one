package application_business_rules_layer.postcreateUseCases;

public interface PostCreateInputBoundary {
    PostCreateResponseModel create(PostCreateRequestModel requestModel);
}
