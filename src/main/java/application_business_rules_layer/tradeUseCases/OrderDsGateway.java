package application_business_rules_layer.tradeUseCases;

import java.util.List;

public interface OrderDsGateway {
    void save(OrderDsRequestModel requestModel);
    List<String> getPurchaseHistoryTagsData(String username);

}
