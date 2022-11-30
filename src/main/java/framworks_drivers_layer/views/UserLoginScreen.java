package framworks_drivers_layer.views;

import Interface_adapters_layer.controller.RecommendationController;
import Interface_adapters_layer.controller.UserLoginController;
import Interface_adapters_layer.controller.UserRegisterController;
import Interface_adapters_layer.presenter.RecommendationResponsePresenter;
import Interface_adapters_layer.presenter.UserRegisterPresenter;
import application_business_rules_layer.postUseCases.PostDsGateway;
import application_business_rules_layer.recommendationUseCases.RecommendationInputBoundry;
import application_business_rules_layer.recommendationUseCases.RecommendationInteractor;
import application_business_rules_layer.recommendationUseCases.RecommendationOutputBoundry;
import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import application_business_rules_layer.userUseCases.UserDsGateway;
import application_business_rules_layer.userUseCases.UserRegisterInputBoundary;
import application_business_rules_layer.userUseCases.UserRegisterInteractor;
import application_business_rules_layer.userUseCases.UserRegisterOutputBoundry;
import enterprise_business_rules_layer.accountEntities.AccountFactory;
import framworks_drivers_layer.dataAccess.FileOrder;
import framworks_drivers_layer.dataAccess.FilePost;
import framworks_drivers_layer.dataAccess.FileUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// Frameworks/Drivers layer

public class UserLoginScreen extends JFrame implements ActionListener {
    /**
     * The username chosen by the user
     */
    JTextField username = new JTextField(15);
    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);

    /**
     * The Interface_adapters.presenter.controller
     */
    UserLoginController userLoginController;

    /**
     * A window with a title and a JButton.
     */
    public UserLoginScreen(UserLoginController controller) {

        this.userLoginController = controller;

        this.setBounds(500, 300, 300, 200);


        JPanel loginPanel = new JPanel();
        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Enter username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Enter password"), password);

        JButton login = new JButton("Login");
        JButton register = new JButton("Sign Up");

        JPanel buttons = new JPanel();
        buttons.add(login);
        buttons.add(register);

        login.addActionListener(this);
        register.addActionListener(this);

        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        loginPanel.add(title);
        loginPanel.add(usernameInfo);
        loginPanel.add(passwordInfo);
        loginPanel.add(buttons);
        this.add(loginPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getActionCommand().equals("Login")) {
            try {
                userLoginController.create(username.getText(),
                        String.valueOf(password.getPassword()));

                this.dispose();
                // create main page
                JFrame jf = new JFrame("main");
                jf.setBounds(400, 300, 600, 300);
                RecommendationOutputBoundry recommendationOutputBoundry = new RecommendationResponsePresenter();
                PostDsGateway post;
                try {
                    post = new FilePost("./posts.csv");
                } catch (IOException e) {
                    throw new RuntimeException("Could not create posts.csv.");
                }
                RecommendationInputBoundry recommendationInputBoundry = new RecommendationInteractor(recommendationOutputBoundry, post);
                OrderDsGateway orderDsGateway;
                try{
                    orderDsGateway = new FileOrder("./orders.csv");
                } catch (IOException e){
                    throw new RuntimeException("Could not create orders.csv");
                }
                RecommendationController recommendationController = new RecommendationController(username.getText(), recommendationInputBoundry, orderDsGateway);
                MainPage mainPage = new MainPage(username.getText(), recommendationController);

                jf.add(mainPage);
                jf.setVisible(true);
                jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);




            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            UserDsGateway gateway;
            try {
                gateway = new FileUser("./users.csv");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            UserRegisterOutputBoundry outputBoundry = new UserRegisterPresenter();
            AccountFactory accountFactory = new AccountFactory();
            UserRegisterInputBoundary interactor = new UserRegisterInteractor(gateway, outputBoundry, accountFactory);
            UserRegisterController controller = new UserRegisterController(interactor);

            UserRegisterScreen userRegisterScreen = new UserRegisterScreen(controller);
            userRegisterScreen.setVisible(true);
            userRegisterScreen.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }


    }
}