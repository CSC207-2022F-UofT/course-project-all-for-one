package presenter;

import entities.Post;

import java.util.LinkedList;

public interface BrowsingPresenter {
    public LinkedList<Post> createBrowsingHistoryPage();
}
