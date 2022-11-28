//package main.java;
//
//
//import main.java.UI.UserCenterPage;
//
//public class Main {
//    public static void main(String[] args) {
//        UserCenterPage userCenterPage = new UserCenterPage();
//=======

import UI.Board;
import UI.PostPage;
import entities.Account;
import entities.AccountFactory;
import entities.Post;
import entities.Wallet;
import gateway.MessageDataManagement;
import gateway.MessageDsGateway;

import javax.swing.*;
import java.awt.*;
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
        Account testBuyer = AccountFactory.create("ddddd", "123456", testBuyerWallet);
        Account testSeller = AccountFactory.create("xavier", "654321", testSellerWaller);


        MessageDsGateway Messages = new MessageDataManagement("./MessageBoard.csv");
        JFrame postPage = new PostPage(testPost, testCreationTime, testBuyer, testSeller, Messages);
        postPage.setVisible(true);
    }
}
