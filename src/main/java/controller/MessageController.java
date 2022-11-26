package controller;

import use_case.MessageInputBoundary;
import use_case.MessageRequestModel;
import use_case.MessageResponseModel;

public class MessageController {
    final MessageInputBoundary messageInput;

    /**
     *
     * @param input the input Message from UI
     */

    public MessageController(MessageInputBoundary input) {
        this.messageInput = input;
    }

    /**
     *
     * @param message the input message
     * @return a responsemodel to UI to handle
     */
    public MessageResponseModel create(String message) {

        MessageRequestModel requestModel = new MessageRequestModel(message);

        return messageInput.create(requestModel);
    }
}
