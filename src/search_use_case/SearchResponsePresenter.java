package search_use_case;

public interface SearchResponsePresenter {
    SearchResponseModel prepareSuccessView(SearchResponseModel searchResponseModel);

    SearchResponseModel prepareFailView(String error);
}
