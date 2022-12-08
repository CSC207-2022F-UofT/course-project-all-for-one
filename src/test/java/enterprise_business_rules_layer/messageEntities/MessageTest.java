package enterprise_business_rules_layer.messageEntities;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MessageTest {
    Message m = new Message("I like this.", "Jack");

    @Test
    public void getContent() {
        assertEquals(m.getContent(), "I like this.");
    }

    @Test
    public void getUsername() {
        assertEquals(m.getUsername(), "Jack");
    }
}