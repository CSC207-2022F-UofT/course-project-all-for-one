package controller;

import entity.Order;
import java.util.List;
import purchase_use_case.PurchaseInputBoundary;
import purchase_use_case.PurchaseRequestModel;
import purchase_use_case.PurchaseResponseModel;

public class PurchaseController {
    final PurchaseInputBoundary purchaseInput;

    public PurchaseController(PurchaseInputBoundary accountGateway){
        this.purchaseInput = accountGateway;
    }

    public PurchaseResponseModel create(List<Order> orders){
        PurchaseRequestModel requestModel = new PurchaseRequestModel(orders);
        return purchaseInput.create(requestModel);
    }
}
