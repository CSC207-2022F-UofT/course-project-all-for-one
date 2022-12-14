package framworks_drivers_layer.views;

import Interface_adapters_layer.controller.UserLoginController;
import Interface_adapters_layer.controller.UserRegisterController;
import Interface_adapters_layer.presenter.UserRegisterPresenter;
import application_business_rules_layer.userUseCases.*;
import enterprise_business_rules_layer.accountEntities.AccountFactory;
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
                UserLoginResponseModel responseModel = userLoginController.create(username.getText(),
                        String.valueOf(password.getPassword()));
                this.dispose();

                // create main page
                JFrame jf = new JFrame("main");
                jf.setBounds(400, 300, 600, 300);

                MainPage mainPage = new MainPage(responseModel.getUsername());

                jf.add(mainPage);
                jf.setVisible(true);
                jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        } else {
            this.dispose();

            UserDsGateway userGateway;
            try {
                userGateway = new FileUser("./users.csv");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            UserRegisterOutputBoundary userRegisterOutputBoundary = new UserRegisterPresenter();
            AccountFactory accountFactory = new AccountFactory();
            UserRegisterInputBoundary userRegisterInputBoundary = new UserRegisterInteractor(userGateway, userRegisterOutputBoundary,
                    accountFactory);

            UserRegisterController controller = new UserRegisterController(userRegisterInputBoundary);
            UserRegisterScreen userRegisterScreen = new UserRegisterScreen(controller);
            userRegisterScreen.setVisible(true);
            userRegisterScreen.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }


    }
}