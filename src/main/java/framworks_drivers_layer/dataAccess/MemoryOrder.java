package framworks_drivers_layer.dataAccess;

import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import application_business_rules_layer.tradeUseCases.OrderDsRequestModel;

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
        orders.put(requestModel.getId(), requestModel);
    }

    /**
     * @param username of the buyer
     * @return tags of items that are bought by username
     */
    @Override
    public List<String> getPurchaseHistoryTagsData(String username){
        List<String> tags = new ArrayList<>();
        for(OrderDsRequestModel orderDsRequestModel: orders.values()){
            if(username.equals(orderDsRequestModel.getBuyerUsername())){
                tags.addAll(orderDsRequestModel.getTags());
            }
        }
        return tags;
    }

}
