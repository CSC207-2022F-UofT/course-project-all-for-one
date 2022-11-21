package Controller;

import use_case.MessageInputBoundary;
import use_case.MessageRequestModel;
import use_case.MessageResponseModel;

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
