package Interface_adapters_layer.controller;

import enterprise_business_rules_layer.postEntities.Post;
import application_business_rules_layer.postcreateUseCases.PostCreateDsGateway;
import Interface_adapters_layer.presenter.SearchPresenter;

import java.util.List;

public class SearchController {

    private final PostCreateDsGateway postDsGateway;

    private final SearchPresenter searchPresenter;

    public SearchController(PostCreateDsGateway postDsGateway, SearchPresenter searchPresenter) {
        this.postDsGateway = postDsGateway;
        this.searchPresenter = searchPresenter;
    }

    public List<Post> create(String keyword){
        List<Post> posts = postDsGateway.findPostsWithKeyword(keyword);
        if (posts.size() == 0){
            return searchPresenter.prepareFailureSearchView();
        } else{
            return searchPresenter.prepareSuccessSearchView(posts);
        }

    }
}


