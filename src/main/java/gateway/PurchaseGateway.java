package gateway;

import entities.PhysicalOrder;

import java.util.List;

public interface PurchaseGateway {
    List<PhysicalOrder> getOrders(String username);
}
