package controller;

import entities.Post;
import gateway.PostDsGateway;
import presenter.SearchPresenter;

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
            return searchPresenter.prepareSuccessSearchView(posts);
        } else{
            return searchPresenter.prepareFailureSearchView();
        }

    }
}


