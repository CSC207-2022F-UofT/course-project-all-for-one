package presenter;

import entities.Post;

import java.util.List;

public interface SearchPresenter {
    List<Post> prepareSuccessSearchView(List<Post> posts);

    List<Post> prepareFailureSearchView();
}
