package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.MessageBoard;

public class MessageDsRequestModel {
    private MessageBoard board;

    public MessageDsRequestModel(MessageBoard board) {
        this.board = board;
    }

    public MessageBoard getBoard() {
        return board;
    }

    public void setBoard(MessageBoard board) {
        this.board = board;
    }
}


