package Interface_adapters_layer.controller;

import enterprise_business_rules_layer.postEntities.Post;
import application_business_rules_layer.tradeUseCases.TradeInputBoundary;
import application_business_rules_layer.tradeUseCases.TradeRequestModel;
import application_business_rules_layer.tradeUseCases.TradeResponseModel;

import java.time.LocalDateTime;

public class TradeController {

    TradeInputBoundary userInput;

    public TradeController(TradeInputBoundary orderGateway) {
        this.userInput = orderGateway;
    }

    /**
     *
     * @param post Post object to be put in TradeRequestModel
     * @param name the name of the shipment information that user input to be put in TradeRequestModel
     * @param phoneNumber the phone number of the shipment information that user input to be put in TradeRequestModel
     * @param address the address of the shipment information that user input to be put in TradeRequestModel
     * @param buyerUsername the username of the buyer to be put in TradeRequestModel
     * @return TradeResponseModel for user interface after processing by the use case
     */
    public TradeResponseModel create(Post post, String name, String phoneNumber, String address, String buyerUsername) {
        LocalDateTime now = LocalDateTime.now();
        TradeRequestModel requestModel = new TradeRequestModel(post, now, name, address, phoneNumber, buyerUsername);

        return userInput.create(requestModel);
    }
}
