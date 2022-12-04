package Interface_adapters_layer.presenter;

import application_business_rules_layer.postUseCases.PostDsGateway;
import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import application_business_rules_layer.tradeUseCases.TradeInputBoundary;
import application_business_rules_layer.tradeUseCases.TradeInteractor;
import application_business_rules_layer.userUseCases.UserDsGateway;
import enterprise_business_rules_layer.orderEntities.PhysicalOrderFactory;
import enterprise_business_rules_layer.postEntities.Post;
import framworks_drivers_layer.dataAccess.FilePost;
import framworks_drivers_layer.views.ConfirmOrderPage;
import Interface_adapters_layer.controller.TradeController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BuyPresenter {

    public static void creatConfirmPage(Post post, String buyUsername,
                                        OrderDsGateway order, UserDsGateway user) {

        TradePresenter presenter = new TradePresenter();
        PhysicalOrderFactory physicalOrderFactory = new PhysicalOrderFactory();
        PostDsGateway postDsGateway;
        try {
            postDsGateway = new FilePost("./posts.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        TradeInputBoundary interactor = new TradeInteractor(order, user, presenter, physicalOrderFactory, postDsGateway);
        TradeController controller = new TradeController(interactor);

        JFrame confirm = new JFrame("confirm page");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        confirm.add(screens);

        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(post, buyUsername, controller);
        screens.add(confirmOrderPage, "welcome");
        cardLayout.show(screens, "trade");
        confirm.pack();
        confirm.setVisible(true);
        confirm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }
}
