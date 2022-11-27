package controller;

import entity.Order;
import java.util.List;

public class PurchaseController {

    PurchaseGateway purchaseGateway;

    public PurchaseController(String username, PurchaseGateway purchaseGateway){
        this.purchaseGateway = purchaseGateway;
    }

    public List<Order> useGateway(String username){
        return purchaseGateway.getOrders(username);
    }
}
