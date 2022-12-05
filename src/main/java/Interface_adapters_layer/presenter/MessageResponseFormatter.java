package Interface_adapters_layer.presenter;

import application_business_rules_layer.messageUseCases.MessageOutputBoundary;
import application_business_rules_layer.messageUseCases.MessageResponseModel;

public class MessageResponseFormatter implements MessageOutputBoundary {
    @Override
    public MessageResponseModel displayBoard(MessageResponseModel response) {


        return response;
    }
}
