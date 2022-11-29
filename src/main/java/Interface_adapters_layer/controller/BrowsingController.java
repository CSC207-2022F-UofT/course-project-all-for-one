package Interface_adapters_layer.controller;

import enterprise_business_rules_layer.postEntities.Post;
import application_business_rules_layer.browsingHistoryUseCases.BrowsingGateway;

import java.util.LinkedList;


public class BrowsingController {
    private final BrowsingGateway BrowsingGateway;
    BrowsingGateway browsingGateway;

    public BrowsingController(String username, BrowsingGateway browsingGateway){
        this.BrowsingGateway = browsingGateway;
    }

    public LinkedList<Post> useGateway(String username){
        return BrowsingGateway.getHistory(username);
    }
}
