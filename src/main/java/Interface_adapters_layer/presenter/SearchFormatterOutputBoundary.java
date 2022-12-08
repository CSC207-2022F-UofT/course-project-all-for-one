package Interface_adapters_layer.presenter;

import application_business_rules_layer.searchUseCases.SearchOutputBoundary;
import enterprise_business_rules_layer.postEntities.Post;

import java.util.List;

public class SearchFormatterOutputBoundary implements SearchOutputBoundary {

    /**
     *
     * @return posts that matches
     */
    @Override
    public List<Post> prepareSuccessSearchView(List<Post> posts){
        return posts;
    }
    /**
     *
     * @param errorMessage describes the error
     * @return the error message
     */

    @Override
    public List<Post> prepareFailureSearchView(String errorMessage){throw new SearchFailureError(errorMessage);}
}
