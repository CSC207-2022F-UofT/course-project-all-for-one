package application_business_rules_layer.tradeUseCases;

import java.util.List;

public interface OrderDsGateway {

    /**
     *
     * @param requestModel the order data to save
     */
    void save(OrderDsRequestModel requestModel);

    /**
     *
     * @param username username of the user that is acting
     * @return the purchase history object that is owned by the user with username in database
     */
    List<String> getPurchaseHistoryTagsData(String username);

}
