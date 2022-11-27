package gateway;

import entities.Order;
import entities.Post;
import use_case.OrderDsRequestModel;

import java.util.List;

public interface OrderDsGateway {
    void save(OrderDsRequestModel requestModel);

}
