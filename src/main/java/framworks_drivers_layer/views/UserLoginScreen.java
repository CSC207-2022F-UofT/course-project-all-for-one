package framworks_drivers_layer.views;

import Interface_adapters_layer.controller.UserLoginController;
import Interface_adapters_layer.controller.UserRegisterController;
import Interface_adapters_layer.presenter.UserRegisterPresenter;
import application_business_rules_layer.userUseCases.UserDsGateway;
import application_business_rules_layer.userUseCases.UserRegisterInputBoundary;
import application_business_rules_layer.userUseCases.UserRegisterInteractor;
import application_business_rules_layer.userUseCases.UserRegisterOutputBoundry;
import enterprise_business_rules_layer.accountEntities.AccountFactory;
import framworks_drivers_layer.dataAccess.FileUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

// Frameworks/Drivers layer

public class UserLoginScreen extends JPanel implements ActionListener {
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);

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
            JOptionPane.showMessageDialog(this, "welcome");
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
            UserRegisterScreen registerScreen = new UserRegisterScreen(controller);

            JFrame register = new JFrame("Sign Up Page");
            CardLayout cardLayout = new CardLayout();
            JPanel screens = new JPanel(cardLayout);
            register.add(screens);

            screens.add(registerScreen, "welcome");
            cardLayout.show(screens, "trade");
            register.pack();
            register.setVisible(true);
            register.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }


    }
}