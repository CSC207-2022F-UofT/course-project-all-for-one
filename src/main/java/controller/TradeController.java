package controller;

import entity.Account;
import entity.Post;
import use_case.TradeInputBoundry;
import use_case.TradeRequestModel;
import use_case.TradeResponseModel;

public class TradeController {

    static TradeInputBoundry userInput;

    public TradeController(TradeInputBoundry orderGateway) {
        this.userInput = orderGateway;
    }

    public static TradeResponseModel create(Post post, String creationTime,
                                            String name, String address, String phoneNumber, Account buyer, Account seller) {
        TradeRequestModel requestModel = new TradeRequestModel(post, creationTime,
                name, address, phoneNumber, buyer, seller);

        return userInput.create(requestModel);
    }
}
