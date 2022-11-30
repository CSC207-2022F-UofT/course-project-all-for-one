package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.Message;
import enterprise_business_rules_layer.messageEntities.MessageBoard;

public class MessageRequestModel {

    private Message message;

    private MessageBoard board;

    private Message delete;

    public MessageRequestModel(String input, String username) {
        this.message = new Message(input, username);
//        this.delete = new Message(delete);
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public MessageBoard getBoard() {
        return board;
    }

    public void setBoard(MessageBoard board) {
        this.board = board;
    }

    public Message getDelete() {
        return delete;
    }

    public void setDelete(Message delete) {
        this.delete = delete;
    }
}
