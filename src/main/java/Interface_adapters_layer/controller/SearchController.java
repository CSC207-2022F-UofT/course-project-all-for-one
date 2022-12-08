package Interface_adapters_layer.controller;

import application_business_rules_layer.postUseCases.PostDsGateway;
import enterprise_business_rules_layer.postEntities.Post;
import application_business_rules_layer.searchUseCases.SearchOutputBoundary;

import java.util.List;

public class SearchController {

    private final PostDsGateway postDsGateway;

    private final SearchOutputBoundary searchOutputBoundary;
    /**
     * @param postDsGateway a SearchFilesGateway instance variable
     * @param searchOutputBoundary an interface which prepares the response
     */

    public SearchController(PostDsGateway postDsGateway, SearchOutputBoundary searchOutputBoundary) {
        this.postDsGateway = postDsGateway;
        this.searchOutputBoundary = searchOutputBoundary;
    }

    public List<Post> create(String keyword){
        List<Post> posts = postDsGateway.findPostsWithKeyword(keyword);
        if (posts.size() == 0){
            return searchOutputBoundary.prepareFailureSearchView("No match found!");
        } else if(keyword.length() == 0){
            return searchOutputBoundary.prepareFailureSearchView("Please enter a keyword!");
        } else{
            return searchOutputBoundary.prepareSuccessSearchView(posts);
        }

    }
}


