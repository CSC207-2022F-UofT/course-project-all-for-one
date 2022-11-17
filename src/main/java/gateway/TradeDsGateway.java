package gateway;

import use_case.TradeDsRequestModel;

public interface TradeDsGateway {
    boolean existsByName(String identifier);

    void save(TradeDsRequestModel requestModel);
}
