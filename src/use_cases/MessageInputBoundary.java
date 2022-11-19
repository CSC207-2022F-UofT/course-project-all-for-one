package use_cases;

import entities.MessageBoard;

public interface MessageInputBoundary {
   MessageResponseModel create(MessageRequestModel requestModel);
}
