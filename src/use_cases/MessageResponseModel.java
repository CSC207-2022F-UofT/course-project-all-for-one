package use_cases;

import entities.Message;
import entities.MessageBoard;

public class MessageResponseModel {

    Message message;
    MessageBoard board;

    public MessageResponseModel(Message message, MessageBoard board) {
        this.message = message;
        this.board = board;
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
}
