package enterprise_business_rules_layer.messageEntities;

import enterprise_business_rules_layer.messageEntities.Message;
import enterprise_business_rules_layer.messageEntities.MessageBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageBoardTest {

    MessageBoard board;
    Message m1;
    Message m2;

    @Before
    public void setUp() throws Exception {
        board = new MessageBoard("iphone");
        m1 = new Message("I like this.", "Jack");
        m2 = new Message("I don't like this.", "Steve");
    }

    @After
    public void tearDown() throws Exception {
        board = null;
    }

    @Test
    public void addMessage() {
        board.addMessage(m1);


        for (List<Message> messageList : board){
            for (Message message : messageList) {
                String username = message.getUsername();
                String content = message.getContent();
                assertEquals(m1.getContent(), content);
                assertEquals(m1.getUsername(), username);

            }

        }
        assertEquals(1,1);
    }

    @Test
    public void iterator() {

    }

    @Test
    public void getName() {
    }
}