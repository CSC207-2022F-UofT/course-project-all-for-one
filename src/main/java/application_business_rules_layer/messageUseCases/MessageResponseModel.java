package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.Message;
import enterprise_business_rules_layer.messageEntities.MessageBoard;

import java.util.ArrayList;
import java.util.List;

public class MessageResponseModel {

    List<String> messageList;

    /**
     *
     * @param board the MessageBoard that is used to creat ResponseModel object.
     */

    public MessageResponseModel(MessageBoard board) {
        this.messageList = new ArrayList<>();
        for (List<Message> ml : board) {
            for (Message m : ml) {
                messageList.add(m.getUsername() + ": " + m.getContent());
            }
        }
    }

    /**
     *
     * @return A list of message content and username in certain format in ResponseModel.
     */
    public List<String> getMessageList() {
        return messageList;
    }
}