package search_use_case;

import Entity.Post;

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
