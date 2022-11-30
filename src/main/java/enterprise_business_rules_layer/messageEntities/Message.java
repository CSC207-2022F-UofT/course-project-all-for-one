package enterprise_business_rules_layer.messageEntities;

public class Message {
    private String content;
    private String username;

    /**
     *
     * @param content the content of a message
     * @param username the username of the user who post the message
     */
    public Message(String content, String username) {
        this.content = content;
        this.username = username;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getUsername() {
        return username;
    }
}



