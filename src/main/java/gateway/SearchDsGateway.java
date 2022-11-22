package gateway;

import use_case.SearchRequestModel;

public interface SearchDsGateway {
    void save(SearchRequestModel requestModel);
}
