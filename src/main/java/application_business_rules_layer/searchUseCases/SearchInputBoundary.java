package application_business_rules_layer.searchUseCases;

public interface SearchInputBoundary {
    SearchResponseModel create(SearchRequestModel requestModel);
}
