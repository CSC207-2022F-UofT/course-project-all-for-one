package application_business_rules_layer.browsingHistoryUseCases;

import enterprise_business_rules_layer.postEntities.Post;

import java.util.LinkedList;

public interface BrowsingGateway {
    LinkedList<Post> getHistory(String username);
}
