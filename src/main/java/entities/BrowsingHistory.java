package entities;

import java.util.LinkedList;
import java.util.Objects;

//
public class BrowsingHistory {

    private LinkedList<Post> history;

    public BrowsingHistory(LinkedList<Post> history) {
        this.history = history;
    }

    public LinkedList<Post> getHistory() {
        return history;
    }

    //
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
//    /*
//    find browsing history record
//     */
//        String id = request.getParameter("id");
//        List<String> history = (List<String>) session.getAttribute("history");

    public LinkedList<Post> store_history(Post post) {
        if (Objects.equals(post.getStatus(), "Active")) {
            if (this.history.contains(post)) {
                history.remove(post);
                history.addFirst(post);
            } else {
                if (history.size() >= 10) {
                    history.removeLast();
                    history.addFirst(post);
                } else {
                    history.addFirst(post);
                }
            }
        }
        return this.history;
    }
}

