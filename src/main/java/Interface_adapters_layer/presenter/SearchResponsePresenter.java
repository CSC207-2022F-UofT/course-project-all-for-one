package Interface_adapters_layer.presenter;

import application_business_rules_layer.searchUseCases.SearchResponseModel;

public interface SearchResponsePresenter {
    SearchResponseModel prepareSuccessView(SearchResponseModel searchResponseModel);

    SearchResponseModel prepareFailView(String error);
}
