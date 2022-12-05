package application_business_rules_layer.searchUseCases;

import enterprise_business_rules_layer.postEntities.Post;

import java.util.List;

public interface SearchOutputBoundary {
    List<Post> prepareSuccessSearchView(List<Post> posts);

    List<Post> prepareFailureSearchView(String errorMessage);
}
