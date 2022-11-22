package Entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageBoard implements Iterable<List<Message>>{

    private String name;
    private List<Message> messages = new ArrayList<>();
    private int BOARD_SIZE = 5;

    public MessageBoard(String name) {
        this.name = name;
    }

    public void addMessage(Message m) {messages.add(m);}

    public void removeMessage(Message m) {messages.remove(m);}

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
}
