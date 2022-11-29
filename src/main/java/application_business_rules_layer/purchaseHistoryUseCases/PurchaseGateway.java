package application_business_rules_layer.purchaseHistoryUseCases;

import enterprise_business_rules_layer.orderEntities.PhysicalOrder;

import java.util.List;

public interface PurchaseGateway {
    List<PhysicalOrder> getOrders(String username);
}
