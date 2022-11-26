import gateway.FilePost;
import UI.PostController;
import UI.PostResponseFormatter;
import UI.PostScreen;
import entities.PostFactory;
import gateway.PostDsGateway;
import use_case.PostInputBoundary;
import use_case.PostInteractor;
import use_case.PostPresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainKevin {
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
        String username = "kevin";
        PostScreen postScreen = new PostScreen(username, postController);
        screens.add(postScreen, "post");
        cardLayout.show(screens, "post");
        application.pack();
        application.setVisible(true);
        application.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // Unused screens; we'll uncomment this later
//        WelcomeScreen welcomeScreen = new WelcomeScreen();
//        LoginScreen loginScreen = new LoginScreen();
//        LoggedInScreen loggedInScreen = new LoggedInScreen();
//        screens.add(welcomeScreen, "register");
//        screens.add(loginScreen, "login");
//        screens.add(loggedInScreen, "loggedIn");

    }
}
