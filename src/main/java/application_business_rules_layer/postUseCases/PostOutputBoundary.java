package application_business_rules_layer.postUseCases;

public interface PostOutputBoundary {
    /**
     *
     * @param post a PostResponseModel the input that needs processing
     * @return return a PostResponseModel object if there is no error
     */
    PostResponseModel prepareSuccessView(PostResponseModel post);
    /**
     *
     * @param error a String that is used to create an Error object
     * @return return a response model that is actually an error
     */
    PostResponseModel prepareFailView(String error);
}