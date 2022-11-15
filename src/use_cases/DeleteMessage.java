package use_cases;

import entities.Message;
import entities.MessageBoard;

public class DeleteMessage {
    public static void deleteMessage(Message message, MessageBoard board) {
        board.removeMessage(message);
    }
}
