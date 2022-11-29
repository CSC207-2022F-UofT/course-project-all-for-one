package application_business_rules_layer.searchUseCases;

import enterprise_business_rules_layer.postEntities.Post;

import java.util.List;

public class SearchResponseModel {
    private List<Post> searchResult;

    public SearchResponseModel(List<Post> searchResult){
        this.searchResult = searchResult;
    }

    public List<Post> getSearchResult() {
        return searchResult;
    }
}
