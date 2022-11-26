package presenter;

import entities.Post;

import java.util.List;

public class SearchFormatterPresenter implements SearchPresenter{
    @Override
    public List<Post> prepareSuccessSearchView(List<Post> posts){
        return posts;
    }

    @Override
    public List<Post> prepareFailureSearchView(){throw new SearchFailureError("No match found!");}
}
