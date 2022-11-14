package controller;

import use_case.TradeInputBoundry;
import use_case.TradeRequestModel;
import use_case.TradeResponseModel;

public class TradeController {

    final TradeInputBoundry userInput;

    public TradeController(TradeInputBoundry orderGateway) {
        this.userInput = orderGateway;
    }

    TradeResponseModel create(String postNumber, String postTitle, String finalPrice, String creationTime,
                              String name, String address, String phoneNumber) {
        TradeRequestModel requestModel = new TradeRequestModel(postNumber, postTitle, finalPrice, creationTime,
                name, address, phoneNumber);

        return userInput.create(requestModel);
    }
}
