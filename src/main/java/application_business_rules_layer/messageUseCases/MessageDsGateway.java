package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.MessageBoard;
import application_business_rules_layer.messageUseCases.MessageDsRequestModel;

public interface MessageDsGateway {

    MessageBoard getBoard(String boardName);

    void save(MessageDsRequestModel requestModel);

//    void delete(String message);






}
