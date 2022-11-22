package Entity;

import java.util.List;
import java.util.Objects;

public class Search {
    private List<Post> searchResult;

    public Search(List<Post> searchResult){
        this.searchResult = searchResult;
    }

    public List<Post> getSearchResult() {
        return searchResult;
    }


    }

