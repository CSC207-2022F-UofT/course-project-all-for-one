import Interface_adapters_layer.controller.UserLoginController;
import Interface_adapters_layer.presenter.UserLoginPresenter;
import application_business_rules_layer.userUseCases.*;
import enterprise_business_rules_layer.accountEntities.AccountFactory;
import Interface_adapters_layer.controller.UserRegisterController;
import framworks_drivers_layer.dataAccess.FileUser;
import Interface_adapters_layer.presenter.UserRegisterPresenter;
import framworks_drivers_layer.views.UserLoginScreen;
import framworks_drivers_layer.views.UserRegisterScreen;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainLogin {
    public static void main(String[] args) {

        // Build the main program window
        JFrame login = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        login.add(screens);

        // Create the parts to plug into the Use Case+Entities engine
        UserDsGateway user;
        try {
            user = new FileUser("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        UserLoginOutputBoundary presenter = new UserLoginPresenter();
        AccountFactory accountFactory = new AccountFactory();
        UserLoginInputBoundary interactor = new UserLoginInteractor(
                user, presenter, accountFactory);
        UserLoginController controller = new UserLoginController(interactor);

        // Build the GUI, plugging in the parts
        UserLoginScreen loginScreen = new UserLoginScreen(controller);
        screens.add(loginScreen, "welcome");
        cardLayout.show(screens, "register");
        login.pack();
        login.setVisible(true);

        // Unused screens; we'll uncomment this later
//        WelcomeScreen welcomeScreen = new WelcomeScreen();
//        LoginScreen loginScreen = new LoginScreen();
//        LoggedInScreen loggedInScreen = new LoggedInScreen();
//        screens.add(welcomeScreen, "register");
//        screens.add(loginScreen, "login");
//        screens.add(loggedInScreen, "loggedIn");

    }

}