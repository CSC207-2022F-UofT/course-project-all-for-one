package Interface_adapters_layer.presenter;

import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import application_business_rules_layer.tradeUseCases.TradeInputBoundry;
import application_business_rules_layer.tradeUseCases.TradeInteractor;
import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.orderEntities.PhysicalOrderFactory;
import enterprise_business_rules_layer.postEntities.Post;
import framworks_drivers_layer.views.ConfirmOrderPage;
import Interface_adapters_layer.controller.TradeController;

import javax.swing.*;
import java.awt.*;

public class BuyPresenter {

    public static void creatConfirmPage(Post post, String creationTime, Account buyer, Account seller, OrderDsGateway order) {

        TradePresenter presenter = new TradePresenter();
        PhysicalOrderFactory physicalOrderFactory = new PhysicalOrderFactory();
        TradeInputBoundry interactor = new TradeInteractor(order, presenter, physicalOrderFactory);
        TradeController controller = new TradeController(interactor);

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
