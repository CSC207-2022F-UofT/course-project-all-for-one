package controller;

import entities.PhysicalOrder;
import java.util.List;
import gateway.PurchaseGateway;

public class PurchaseController {

    PurchaseGateway purchaseGateway;

    public PurchaseController(String username, PurchaseGateway purchaseGateway){
        this.purchaseGateway = purchaseGateway;
    }

    public List<PhysicalOrder> useGateway(String username){
        return purchaseGateway.getOrders(username);
    }
}
