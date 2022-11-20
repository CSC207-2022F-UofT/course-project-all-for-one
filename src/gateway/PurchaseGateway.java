package gateway;

import entity.Order;
import java.util.List;

public interface PurchaseGateway {
    List<Order> getOrders(String username);
}
