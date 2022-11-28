package gateway;

import entities.Post;
import use_case.OrderDsRequestModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
