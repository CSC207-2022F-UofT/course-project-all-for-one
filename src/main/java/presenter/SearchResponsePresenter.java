package presenter;

import use_case.SearchResponseModel;

public interface SearchResponsePresenter {
    SearchResponseModel prepareSuccessView(SearchResponseModel searchResponseModel);

    SearchResponseModel prepareFailView(String error);
}
