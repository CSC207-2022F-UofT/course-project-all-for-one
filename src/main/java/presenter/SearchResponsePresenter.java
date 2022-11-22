package presenter;

public interface SearchResponsePresenter {
    SearchResponseModel prepareSuccessView(SearchResponseModel searchResponseModel);

    SearchResponseModel prepareFailView(String error);
}
