package use_case;

import entity.Message;
import entity.MessageBoard;

import java.util.ArrayList;
import java.util.List;

public class MessageResponseModel {

    List<String> messageList;


    public MessageResponseModel(MessageBoard board) {
        this.messageList = new ArrayList<>();
        for (List<Message> ml : board) {
            for (Message m : ml) {
                messageList.add(m.getContent());
            }
        }
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    //    public Message getMessage() {
//        return message;
//    }
//
//    public void setMessage(Message message) {
//        this.message = message;
//    }
//
//    public MessageBoard getBoard() {
//        return board;
//    }
//
//    public void setBoard(MessageBoard board) {
//        this.board = board;

}
