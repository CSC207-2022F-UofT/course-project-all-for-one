package Interface_adapters_layer.presenter;

import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.postEntities.Post;
import framworks_drivers_layer.views.ConfirmOrderPage;
import Interface_adapters_layer.controller.TradeController;

import javax.swing.*;
import java.awt.*;

public class BuyPresenter {

    public static void creatConfirmPage(Post post, String creationTime, Account buyer, Account seller,
                                        TradeController controller) {

        JFrame confirm = new JFrame("confirm page");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        confirm.add(screens);

        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(post, creationTime, buyer, seller,
                controller);
        screens.add(confirmOrderPage, "welcome");
        cardLayout.show(screens, "trade");
        confirm.pack();
        confirm.setVisible(true);
        confirm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }
}
