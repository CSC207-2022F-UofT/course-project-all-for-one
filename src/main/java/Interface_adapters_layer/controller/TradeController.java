package Interface_adapters_layer.controller;

import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.postEntities.Post;
import application_business_rules_layer.tradeUseCases.TradeInputBoundry;
import application_business_rules_layer.tradeUseCases.TradeRequestModel;
import application_business_rules_layer.tradeUseCases.TradeResponseModel;

import java.time.LocalDateTime;

public class TradeController {

    TradeInputBoundry userInput;

    public TradeController(TradeInputBoundry orderGateway) {
        this.userInput = orderGateway;
    }

    public TradeResponseModel create(Post post, String name, String address, String phoneNumber, String buyerUsername,
                                            String sellerUsername, Account buyer, Account seller) {
        LocalDateTime now = LocalDateTime.now();
        TradeRequestModel requestModel = new TradeRequestModel(post, now,
                name, address, phoneNumber, buyerUsername, sellerUsername, buyer, seller);

        return userInput.create(requestModel);
    }
}
