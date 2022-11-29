package framworks_drivers_layer.dataAccess;

import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import application_business_rules_layer.tradeUseCases.OrderDsRequestModel;

import java.util.HashMap;
import java.util.Map;

public class MemoryOrder implements OrderDsGateway {

    final private Map<String, OrderDsRequestModel> orders = new HashMap<>();


    /**
     * @param requestModel the data to save
     */
    @Override
    public void save(OrderDsRequestModel requestModel) {
        System.out.println("Save " + requestModel.getSellerUsername() + ": " + requestModel.getTitle());
        orders.put(requestModel.getSellerUsername(), requestModel);
    }

}
