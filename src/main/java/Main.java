 20-profile-20
package main.java;


import main.java.UI.UserCenterPage;

public class Main {
    public static void main(String[] args) {
        UserCenterPage userCenterPage = new UserCenterPage();
=======
import UI.ConfirmPage;
import UI.PostPage;
import controller.TradeController;
import entity.*;
import presenter.TradePresenter;
import use_case.TradeInputBoundry;
import use_case.TradeInteractor;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame post = new JFrame("post page");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        post.add(screens);

        Post testPost = new Post("Iphone18", "DNE phone", 10);
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

    }
}
