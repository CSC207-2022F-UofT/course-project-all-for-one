package gateway;

import entity.Order;
import use_case.PurchaseRequestModel;

import java.util.List;

public interface PurchaseGateway {
    List<String> getCreationTimes(String username);

    void save(PurchaseRequestModel requestModel);
}
