package Interface_adapters_layer.presenter;

import enterprise_business_rules_layer.postEntities.Post;

import java.util.List;

public class SearchFormatterPresenter implements SearchPresenter{
    @Override
    public List<Post> prepareSuccessSearchView(List<Post> posts){
        return posts;
    }

    @Override
    public List<Post> prepareFailureSearchView(String errorMessage){throw new SearchFailureError(errorMessage);}
}
