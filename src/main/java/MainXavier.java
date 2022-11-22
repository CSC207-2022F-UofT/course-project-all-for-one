//package main.java;
//
//
//import main.java.UI.UserCenterPage;
//
//public class Main {
//    public static void main(String[] args) {
//        UserCenterPage userCenterPage = new UserCenterPage();
//=======

import UI.PostPage;
import entities.Account;
import entities.AccountFactory;
import entities.Post;
import entities.Wallet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainXavier {
    public static void main(String[] args) {

        JFrame post = new JFrame("post page");
        post.setBounds(400,400,400,400);
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        post.add(screens);

        ArrayList<String> tags = new ArrayList<>();
        tags.add(0, "xxx");
        Post testPost = new Post("Steve", "iphone18", "DNE", 10, tags);
        String testCreationTime = "today";
        Wallet testBuyerWallet = new Wallet(100);
        Wallet testSellerWaller = new Wallet(50);
        Account testBuyer = AccountFactory.create("steve", "123456", testBuyerWallet);
        Account testSeller = AccountFactory.create("xavier", "654321", testSellerWaller);

        PostPage postPage = new PostPage(testPost, testCreationTime, testBuyer, testSeller);

        screens.add(postPage, "welcome");
        cardLayout.show(screens, "trade");

        post.pack();
        post.setVisible(true);
        post.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }
}
