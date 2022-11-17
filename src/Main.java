import UI.ConfirmPage;
import controller.TradeController;
import entity.*;
import presenter.TradePresenter;
import use_case.TradeInputBoundry;
import use_case.TradeInteractor;

import javax.swing.*;
import java.awt.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        JFrame confirm = new JFrame("confirm page");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        confirm.add(screens);

        TradePresenter presenter = new TradePresenter();
        OrderFactory orderFactory = new OrderFactory();
        TradeInputBoundry interactor = new TradeInteractor(presenter, orderFactory);
        TradeController controller = new TradeController(interactor);

        Post testPost = new Post("Iphone18", "DNE phone", 10000);
        double testFinalPrice = 19.99;
        String testCreationTime = "today";
        Wallet testBuyerWallet = new Wallet(100);
        Wallet testSellerWaller = new Wallet(50);
        Account testBuyer = AccountFactory.create("steve", "123456", testBuyerWallet);
        Account testSeller = AccountFactory.create("xavier", "654321", testSellerWaller);

        ConfirmPage confirmPage = new ConfirmPage(testPost, testFinalPrice, testCreationTime, testBuyer, testSeller, controller);
        screens.add(confirmPage, "welcome");
        cardLayout.show(screens, "trade");
        confirm.pack();
        confirm.setVisible(true);
    }
}
