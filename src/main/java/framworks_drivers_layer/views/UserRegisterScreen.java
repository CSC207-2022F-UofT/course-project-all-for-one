package framworks_drivers_layer.views;

import Interface_adapters_layer.controller.UserLoginController;
import Interface_adapters_layer.controller.UserRegisterController;
import Interface_adapters_layer.presenter.UserLoginPresenter;
import application_business_rules_layer.profileUseCases.ProfileGateway;
import application_business_rules_layer.profileUseCases.ProfileRequestModel;
import application_business_rules_layer.userUseCases.UserDsGateway;
import application_business_rules_layer.userUseCases.UserLoginInputBoundary;
import application_business_rules_layer.userUseCases.UserLoginInteractor;
import application_business_rules_layer.userUseCases.UserLoginOutputBoundary;
import enterprise_business_rules_layer.accountEntities.AccountFactory;
import framworks_drivers_layer.dataAccess.FileProfile;
import framworks_drivers_layer.dataAccess.FileUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// Frameworks/Drivers layer

public class UserRegisterScreen extends JFrame implements ActionListener {
    /**
     * The username chosen by the user
     */
    JTextField username = new JTextField(15);
    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);
    /**
     * The second password to make sure the user understands
     */
    JPasswordField repeatPassword = new JPasswordField(15);

    /**
     * The Interface_adapters.presenter.controller
     */
    UserRegisterController userRegisterController;

    /**
     * A window with a title and a JButton.
     */
    public UserRegisterScreen(UserRegisterController controller) {

        this.userRegisterController = controller;

        this.setName("Sign up page");
        this.setBounds(400, 300, 400, 300);
        JPanel registerPanel = new JPanel();
        JLabel title = new JLabel("Register Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Choose username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Choose password"), password);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel("Enter password again"), repeatPassword);

        JButton signUp = new JButton("Sign up");

        JPanel buttons = new JPanel();
        buttons.add(signUp);

        signUp.addActionListener(this);

        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));

        registerPanel.add(title);
        registerPanel.add(usernameInfo);
        registerPanel.add(passwordInfo);
        registerPanel.add(repeatPasswordInfo);
        registerPanel.add(buttons);
        this.add(registerPanel);


    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try {
            userRegisterController.create(username.getText(),
                    String.valueOf(password.getPassword()),
                    String.valueOf(repeatPassword.getPassword()));
            JOptionPane.showMessageDialog(this, username.getText() + " created.");
            this.dispose();

            UserDsGateway user;
            try {
                user = new FileUser("./users.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create file.");
            }

//            ProfileGateway profile;
//            try {
//                profile = new FileProfile("./profile.csv");
//            } catch (IOException e) {
//                throw new RuntimeException("Could not create file.");
//            }
//
//            ProfileRequestModel profileRequestModel = new ProfileRequestModel(username.getText()," "," "," "," " +
//                    " "," ");
//            profile.save(profileRequestModel);

            UserLoginOutputBoundary presenter = new UserLoginPresenter();
            AccountFactory accountFactory = new AccountFactory();
            UserLoginInputBoundary interactor = new UserLoginInteractor(
                    user, presenter, accountFactory);
            UserLoginController controller = new UserLoginController(interactor);

            // Build the GUI, plugging in the parts
            UserLoginScreen loginScreen = new UserLoginScreen(controller);


            loginScreen.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}