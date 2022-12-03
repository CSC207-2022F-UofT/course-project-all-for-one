package application_business_rules_layer.postUseCases;

public interface PostOutputBoundary {
    PostResponseModel prepareSuccessView(PostResponseModel post);

    PostResponseModel prepareFailView(String error);
}