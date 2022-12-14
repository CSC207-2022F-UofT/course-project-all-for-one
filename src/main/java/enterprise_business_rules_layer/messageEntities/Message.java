package enterprise_business_rules_layer.messageEntities;

public class Message {
    private final String content;
    private final String username;

    /**
     *
     * @param content the content of a message
     * @param username the username of the user who post the message
     */
    public Message(String content, String username) {
        this.content = content;
        this.username = username;
    }

    /**
     * @return the content of the Message.
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @return the username of the Message.
     */
    public String getUsername() {
        return username;
    }
}



