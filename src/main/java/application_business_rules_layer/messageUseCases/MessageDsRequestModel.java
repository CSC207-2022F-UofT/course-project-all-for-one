package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.Message;
import enterprise_business_rules_layer.messageEntities.MessageBoard;

public class MessageDsRequestModel {
    private MessageBoard board;
    private Message message;

    public MessageDsRequestModel(MessageBoard board, Message message) {
        this.board = board;
        this.message = message;
    }

    public MessageBoard getBoard() {
        return board;
    }

    public Message getMessage() {
        return message;
    }
}


