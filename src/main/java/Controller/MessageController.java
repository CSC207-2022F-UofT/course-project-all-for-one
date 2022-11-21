package Controller;

import use_cases.MessageInputBoundary;
import use_cases.MessageRequestModel;
import use_cases.MessageResponseModel;

public class MessageController {
    final MessageInputBoundary messageInput;

    public MessageController(MessageInputBoundary input) {
        this.messageInput = input;
    }

    public MessageResponseModel create(String message) {
        MessageRequestModel requestModel = new MessageRequestModel(message);

        return messageInput.create(requestModel);
    }
}
