package use_cases;

import entities.Message;
import entities.MessageBoard;

public class DeleteMessage {
    public void deleteMessage(Message message, MessageBoard board) {
        board.removeMessage(message);
    }
}
