package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.Message;
import enterprise_business_rules_layer.messageEntities.MessageBoard;

public record MessageDsRequestModel(MessageBoard board, Message message) {
}


