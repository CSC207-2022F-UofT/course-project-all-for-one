package Controller;

import use_cases.MessageInputBoundary;
import use_cases.MessageRequestModel;
import use_cases.MessageResponseModel;

public class MessageController {
    final MessageInputBoundary messageInput;

    public MessageController(MessageInputBoundary input) {
        this.messageInput = input;
    }

    MessageResponseModel create(String message, String delete) {
        MessageRequestModel requestModel = new MessageRequestModel(message, delete);

        return messageInput.create(requestModel);
    }
}
