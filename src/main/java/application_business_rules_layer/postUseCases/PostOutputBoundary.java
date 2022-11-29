package application_business_rules_layer.postUseCases;

import application_business_rules_layer.postUseCases.PostResponseModel;

public interface PostOutputBoundary {
    PostResponseModel prepareSuccessView(PostResponseModel post);

    PostResponseModel prepareFailView(String error);
}