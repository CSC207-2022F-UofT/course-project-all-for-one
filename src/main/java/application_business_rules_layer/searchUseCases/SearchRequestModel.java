package application_business_rules_layer.searchUseCases;

import enterprise_business_rules_layer.postEntities.Post;

import java.util.List;

public class SearchRequestModel {
    private List<Post> searchResult;

    public SearchRequestModel(List<Post> searchResult){
        this.searchResult = searchResult;
    }

    public List<Post> getSearchResult() {
        return searchResult;
    }
}
