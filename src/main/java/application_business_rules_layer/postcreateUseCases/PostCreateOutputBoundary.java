package application_business_rules_layer.postcreateUseCases;

public interface PostCreateOutputBoundary {
    PostCreateResponseModel prepareSuccessView(PostCreateResponseModel post);

    PostCreateResponseModel prepareFailView(String error);
}