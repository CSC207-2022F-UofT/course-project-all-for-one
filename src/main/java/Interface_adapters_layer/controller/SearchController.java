package Interface_adapters_layer.controller;

import application_business_rules_layer.postUseCases.PostDsGateway;
import enterprise_business_rules_layer.postEntities.Post;
import Interface_adapters_layer.presenter.SearchPresenter;

import java.util.List;

public class SearchController {

    private final PostDsGateway postDsGateway;

    private final SearchPresenter searchPresenter;

    public SearchController(PostDsGateway postDsGateway, SearchPresenter searchPresenter) {
        this.postDsGateway = postDsGateway;
        this.searchPresenter = searchPresenter;
    }

    public List<Post> create(String keyword){
        List<Post> posts = postDsGateway.findPostsWithKeyword(keyword);
        if (posts.size() == 0){
            return searchPresenter.prepareFailureSearchView("No match found!");
        } else if(keyword.length() == 0){
            return searchPresenter.prepareFailureSearchView("Please enter a keyword!");
        } else{
            return searchPresenter.prepareSuccessSearchView(posts);
        }

    }
}


