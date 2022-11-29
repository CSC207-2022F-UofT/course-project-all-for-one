package Interface_adapters_layer.presenter;

import enterprise_business_rules_layer.postEntities.Post;

import java.util.LinkedList;

public interface BrowsingPresenter {
    public LinkedList<Post> createBrowsingHistoryPage();
}
