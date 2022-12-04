package Interface_adapters_layer.presenter;

import enterprise_business_rules_layer.postEntities.Post;

import java.util.List;

public interface SearchPresenter {
    List<Post> prepareSuccessSearchView(List<Post> posts);

    List<Post> prepareFailureSearchView(String errorMessage);
}
