package use_case;

public interface MessageInputBoundary {
   MessageResponseModel create(MessageRequestModel requestModel);
}
