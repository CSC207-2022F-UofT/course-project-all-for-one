package presenter;

import UI.ConfirmPage;
import controller.TradeController;
import entity.*;
import use_case.TradeInputBoundry;
import use_case.TradeInteractor;

import javax.swing.*;
import java.awt.*;

public class BuyPresenter {

    public static void creatConfirmPage(Post post, String creationTime, Account buyer, Account seller,
                                        TradeController controller) {
        JFrame confirm = new JFrame("confirm page");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        confirm.add(screens);

        ConfirmPage confirmPage = new ConfirmPage(post, creationTime, buyer, seller,
                controller);
        screens.add(confirmPage, "welcome");
        cardLayout.show(screens, "trade");
        confirm.pack();
        confirm.setVisible(true);

    }
}
