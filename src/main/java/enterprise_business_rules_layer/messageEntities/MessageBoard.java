package enterprise_business_rules_layer.messageEntities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageBoard implements Iterable<List<Message>>{

    private final String name;
    private final List<Message> messages = new ArrayList<>();
    private final int BOARD_SIZE = 5;

    /**
     *
     * @param name the name of the MessageBoard.
     */
    public MessageBoard(String name) {
        this.name = name;
    }

    /**
     *
     * @param m the message added to the MessageBoard.
     */
    public void addMessage(Message m) {messages.add(m);}

    @Override

    public Iterator<List<Message>> iterator() {
        return new MessageBoardIterator();
    }

    private class MessageBoardIterator implements Iterator<List<Message>> {
        private int current;
        @Override
        public boolean hasNext() {
            return current < messages.size();
        }

        @Override
        public List<Message> next() {
            List<Message> temp = new ArrayList<>();
            while (temp.size() < BOARD_SIZE && hasNext()) {
                temp.add(messages.get(current ++));
            }
            return temp;
        }
    }

    /**
     *
     * @return the name of the MessageBoard.
     */
    public String getName() {
        return name;
    }

}
