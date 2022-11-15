package use_cases;

import entities.Message;
import entities.MessageBoard;

public class MessageInteractor implements MessageInputBoundary {
    private final MessageOutputBoundary messageOutputBoundary;

    private Message message;
    private MessageBoard messageBoard;



    public MessageInteractor(MessageOutputBoundary messageOutputBoundary) {
        this.messageOutputBoundary = messageOutputBoundary;

    }

    @Override
    public void inputMessage(String content, MessageBoard board) {
        this.message = new Message(content);
        this.messageBoard = board;
        AddMessage.addMessage(this.message, this.messageBoard);
        messageOutputBoundary.displayMessage(this.messageBoard);

    }

    @Override
    public void deleteMessage(String content, MessageBoard board) {
        this.message = new Message(content);
        this.messageBoard = board;
        DeleteMessage.deleteMessage(this.message, this.messageBoard);
        messageOutputBoundary.displayMessage(this.messageBoard);
    }
}
