package presenter;

import entities.Post;

import java.util.LinkedList;

public class BrowsingResponsePresenter implements BrowsingPresenter{
        public LinkedList<Post> createBrowsingHistoryPage(LinkedList<Post> posts){
            return posts;
        }
}
