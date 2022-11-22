package gateway;

import entities.Post;

import java.util.LinkedList;

public interface BrowsingGateway {
    LinkedList<Post> getHistory(String username);
}
