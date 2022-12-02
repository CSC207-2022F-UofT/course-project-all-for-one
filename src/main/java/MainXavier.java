//package main.java;
//
//
//import main.java.framworks_drivers.UI.UserCenterPage;
//
//public class Main {
//    public static void main(String[] args) {
//        UserCenterPage userCenterPage = new UserCenterPage();
//=======

import framworks_drivers_layer.views.PostPage;
import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.accountEntities.AccountFactory;
import enterprise_business_rules_layer.postEntities.Post;
import enterprise_business_rules_layer.Wallet;
import framworks_drivers_layer.dataAccess.FileMessage;
import application_business_rules_layer.messageUseCases.MessageDsGateway;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class  MainXavier {
    public static void main(String[] args) throws FileNotFoundException {



        ArrayList<String> tags = new ArrayList<>();
        tags.add(0, "xxx");
        Post testPost = new Post("Steve", "iphone19", "DNE", 10, tags);
        String testCreationTime = "today";
        Wallet testBuyerWallet = new Wallet(100);
        Wallet testSellerWaller = new Wallet(50);
        String testBuyerUsername = "steve";


        MessageDsGateway Messages = new FileMessage("./MessageBoard.csv");
        JFrame postPage = new PostPage(testPost, testBuyerUsername, Messages);
        postPage.setVisible(true);
    }
}
