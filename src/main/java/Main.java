import UI.*;
import controller.UserRegisterController;
import gateway.FileUser;
import presenter.UserRegisterPresenter;
import use_case.*;
import entities.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case+Entities engine
        UserDsGateway user;
        try {
            user = new FileUser("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        UserRegisterOutputBoundry presenter = new UserRegisterPresenter();
        AccountFactory accountFactory = new GeneralAccountFactory();
        UserRegisterInputBoundary interactor = new UserRegisterInteractor(
                user, presenter, accountFactory);
        UserRegisterController userRegisterController = new UserRegisterController(
                interactor
        );

        // Build the GUI, plugging in the parts
        UserRegisterScreen registerScreen = new UserRegisterScreen(userRegisterController);
        screens.add(registerScreen, "welcome");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);

        // Unused screens; we'll uncomment this later
//        WelcomeScreen welcomeScreen = new WelcomeScreen();
//        LoginScreen loginScreen = new LoginScreen();
//        LoggedInScreen loggedInScreen = new LoggedInScreen();
//        screens.add(welcomeScreen, "register");
//        screens.add(loginScreen, "login");
//        screens.add(loggedInScreen, "loggedIn");

    }

}