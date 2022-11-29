package Interface_adapters_layer.controller;

import enterprise_business_rules_layer.orderEntities.PhysicalOrder;
import java.util.List;
import application_business_rules_layer.purchaseHistoryUseCases.PurchaseGateway;

public class PurchaseController {

    PurchaseGateway purchaseGateway;

    public PurchaseController(String username, PurchaseGateway purchaseGateway){
        this.purchaseGateway = purchaseGateway;
    }

    public List<PhysicalOrder> useGateway(String username){
        return purchaseGateway.getOrders(username);
    }
}
