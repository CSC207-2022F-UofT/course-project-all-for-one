package use_cases;

import entities.Message;
import entities.MessageBoard;

public class AddMessage {
    public static void addMessage(Message message, MessageBoard board) {
        board.addMessage(message);
    }
}
