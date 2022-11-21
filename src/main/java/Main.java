import UI.*;
import use_case.PostInputBoundary;
import use_case.PostPresenter;
import use_case.PostDsGateway;
import use_case.PostInteractor;
import entity.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("Post Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case+Entities engine
        PostDsGateway post;
        try {
            post = new FilePost("./posts.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        PostPresenter presenter = new PostResponseFormatter();
        PostFactory postFactory = new PostFactory();
        PostInputBoundary interactor = new PostInteractor(
                post, presenter, postFactory);
        PostController postController = new PostController(
                interactor
        );

        // Build the GUI, plugging in the parts
        PostScreen postScreen = new PostScreen(postController);
        screens.add(postScreen, "post");
        cardLayout.show(screens, "post");
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
