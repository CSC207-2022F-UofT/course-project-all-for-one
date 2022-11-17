package controller;

import use_case.BuyInputBoundry;
import use_case.BuyRequestModel;
import use_case.BuyResponseModel;

public class BuyController {

    final BuyInputBoundry userInput;

    public BuyController(BuyInputBoundry accountGateway) {
        this.userInput = accountGateway;
    }

    public BuyResponseModel create(String number) {
        BuyRequestModel requestModel = new BuyRequestModel(number);

        return userInput.create(requestModel);
    }
}
