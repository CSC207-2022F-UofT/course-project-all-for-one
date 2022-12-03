package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.Message;

public class MessageRequestModel {

    private Message message;
    private String BoardName;

    /**
     *
     * @param input The message user input from the text area.
     * @param username The username of user who input the message.
     * @param boardName The name of the MessageBoard.
     */

    public MessageRequestModel(String input, String username, String boardName) {
        this.message = new Message(input, username);
        this.BoardName = boardName;
    }

    /**
     *
     * @return the Message in MessageRequestModel.
     */
    public Message getMessage() {
        return message;
    }

    /**
     *
     * @return The name of the MessageBoard in MessageRequestModel.
     */
    public String getBoardName() {
        return BoardName;
    }
}