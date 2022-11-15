package use_cases;

import entities.MessageBoard;

public interface MessageInputBoundary {
    void inputMessage(String content, MessageBoard bord);

    void deleteMessage(String content, MessageBoard board);
}
