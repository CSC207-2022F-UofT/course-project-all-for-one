package application_business_rules_layer.messageUseCases;

public interface MessageInputBoundary {
   MessageResponseModel create(MessageRequestModel requestModel);
}
