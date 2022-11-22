package use_case;

import entities.Search;
import entities.SearchFactory;
import gateway.SearchDsGateway;
import presenter.SearchResponsePresenter;

public class SearchInteractor implements SearchInputBoundary{
    final SearchDsGateway searchDsGateway;
    final SearchResponsePresenter searchResponsePresenter;
    final SearchFactory searchFactory;

    public SearchInteractor(SearchDsGateway searchDsGateway, SearchResponsePresenter searchResponsePresenter,
                            SearchFactory searchFactory) {
        this.searchDsGateway = searchDsGateway;
        this.searchResponsePresenter = searchResponsePresenter;
        this.searchFactory = searchFactory;
    }

    @Override
    public SearchResponseModel create(SearchRequestModel requestModel) {

        Search post = SearchFactory.create(requestModel.getSearchResult());

        return null;
    }
}

