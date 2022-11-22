package use_case;

import Entity.MessageBoard;

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


