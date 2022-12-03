package Interface_adapters_layer.controller;

import application_business_rules_layer.messageUseCases.MessageInputBoundary;
import application_business_rules_layer.messageUseCases.MessageRequestModel;
import application_business_rules_layer.messageUseCases.MessageResponseModel;

public class MessageController {
    final MessageInputBoundary messageInput;

    /**
     *
     * @param input the input Message from framworks_drivers.UI
     */

    public MessageController(MessageInputBoundary input) {
        this.messageInput = input;

    }

    /**
     *
     * @param message the input message
     * @return a responsemodel to framworks_drivers.UI to handle
     */
    public MessageResponseModel create(String message, String username, String boardName) {

        MessageRequestModel requestModel = new MessageRequestModel(message, username, boardName);

        return messageInput.create(requestModel);
    }
}
