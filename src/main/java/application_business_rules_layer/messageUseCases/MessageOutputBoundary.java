package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.MessageBoard;

public interface MessageOutputBoundary {

    void displayMessage(MessageBoard board);
}
