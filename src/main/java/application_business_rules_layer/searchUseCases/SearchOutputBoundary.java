package application_business_rules_layer.searchUseCases;

import enterprise_business_rules_layer.postEntities.Post;

import java.util.List;

public interface SearchOutputBoundary {
    /**
     *
     * @param posts the input that needs processing
     * @return return a list of posts if there is no error
     */
    List<Post> prepareSuccessSearchView(List<Post> posts);
    /**
     *
     * @param errorMessage a String that describe the error
     * @return return a response model that is actually an error
     */
    List<Post> prepareFailureSearchView(String errorMessage);
}
