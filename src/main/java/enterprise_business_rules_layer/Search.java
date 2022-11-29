package enterprise_business_rules_layer;

import enterprise_business_rules_layer.postEntities.Post;

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

