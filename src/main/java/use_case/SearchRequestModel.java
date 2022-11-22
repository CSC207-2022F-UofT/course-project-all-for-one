package use_case;

import Entity.Post;

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
