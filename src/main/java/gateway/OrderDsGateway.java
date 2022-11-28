package gateway;

import use_case.OrderDsRequestModel;

public interface OrderDsGateway {
    void save(OrderDsRequestModel requestModel);

}
