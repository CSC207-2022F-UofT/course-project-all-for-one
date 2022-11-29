package application_business_rules_layer.tradeUseCases;

import application_business_rules_layer.tradeUseCases.OrderDsRequestModel;

public interface OrderDsGateway {
    void save(OrderDsRequestModel requestModel);

}
