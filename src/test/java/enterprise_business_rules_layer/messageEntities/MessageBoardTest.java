package enterprise_business_rules_layer.messageEntities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageBoardTest {

    MessageBoard board = new MessageBoard("iphone");;
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
        board = new MessageBoard("iphone");
    }

    @BeforeClass
    public static void setUpClass() {}

    @AfterClass
    public static void afterClass() {}

    @Test
    public void addMessage() {
        board.addMessage(m1);


        for (List<Message> messageList : board) {
            assertTrue(messageList.contains(m1));
        }

    }


    @Test
    public void getName() {
        assertEquals(board.getName(), "iphone");
    }


}