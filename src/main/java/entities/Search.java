package entities;

import java.util.List;

public class Search {
    private List<Post> searchResult;

    public Search(List<Post> searchResult){
        this.searchResult = searchResult;
    }

    public List<Post> getSearchResult() {
        return searchResult;
    }


    }

