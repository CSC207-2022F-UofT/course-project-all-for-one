package entities;

import entities.BrowsingHistory;

import java.util.LinkedList;

public interface BrowsingHistoryFactory {
    BrowsingHistory create(LinkedList<Post> history);
}
