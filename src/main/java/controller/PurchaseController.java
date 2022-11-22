package controller;

import entities.Order;
import java.util.List;
import gateway.PurchaseGateway;

public class PurchaseController {

    PurchaseGateway purchaseGateway;

    public PurchaseController(String username, PurchaseGateway purchaseGateway){
        this.purchaseGateway = purchaseGateway;
    }

    public List<Order> useGateway(String username){
        return purchaseGateway.getOrders(username);
    }
}
