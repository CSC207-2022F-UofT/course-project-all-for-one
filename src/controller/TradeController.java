package controller;

import use_case.TradeInputBoundry;
import use_case.TradeRequestModel;
import use_case.TradeResponseModel;

public class TradeController {

    final TradeInputBoundry userInput;

    public TradeController(TradeInputBoundry accountGateway) {
        this.userInput = accountGateway;
    }

    public TradeResponseModel create(String number) {
        TradeRequestModel requestModel = new TradeRequestModel(number);

        return userInput.create(requestModel);
    }
}
