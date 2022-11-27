package controller;

import entities.Account;
import entities.Post;
import use_case.TradeInputBoundry;
import use_case.TradeRequestModel;
import use_case.TradeResponseModel;

public class TradeController {

    TradeInputBoundry userInput;

    public TradeController(TradeInputBoundry orderGateway) {
        this.userInput = orderGateway;
    }

    public TradeResponseModel create(Post post, String creationTime,
                                            String name, String address, String phoneNumber, String buyerUsername,
                                            String sellerUsername, Account buyer, Account seller) {
        TradeRequestModel requestModel = new TradeRequestModel(post, creationTime,
                name, address, phoneNumber, buyerUsername, sellerUsername, buyer, seller);

        return userInput.create(requestModel);
    }
}
