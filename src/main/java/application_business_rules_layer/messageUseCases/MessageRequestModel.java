package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.Message;

public class MessageRequestModel {

    private Message message;
    private String BoardName;

    public MessageRequestModel(String input, String username, String boardName) {
        this.message = new Message(input, username);
        this.BoardName = boardName;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getBoardName() {
        return BoardName;
    }
}