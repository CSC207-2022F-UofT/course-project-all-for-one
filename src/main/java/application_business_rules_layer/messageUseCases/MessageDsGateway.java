package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.MessageBoard;

public interface MessageDsGateway {
    /**
     *
     * @param boardName the name of the MessageBoard we need to grab from database
     * @return return the MessageBoard get from database
     */
    MessageBoard getBoard(String boardName);

    /**
     *
     * @param requestModel the data we want to save in database
     */
    void save(MessageDsRequestModel requestModel);








}
