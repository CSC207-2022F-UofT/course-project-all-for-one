package controller;

import entities.Post;
import gateway.BrowsingGateway;

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
