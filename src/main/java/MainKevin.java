import application_business_rules_layer.postcreateUseCases.PostCreateDsGateway;
import framworks_drivers_layer.dataAccess.FilePost;
import framworks_drivers_layer.views.PostController;
import framworks_drivers_layer.views.PostResponseFormatter;
import framworks_drivers_layer.views.PostCreationPage;
import enterprise_business_rules_layer.postEntities.PostFactory;
import application_business_rules_layer.postcreateUseCases.PostCreateInputBoundary;
import application_business_rules_layer.postcreateUseCases.PostCreateInteractor;
import application_business_rules_layer.postcreateUseCases.PostCreateOutputBoundary;

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
        PostCreateDsGateway post;
        try {
            post = new FilePost("./posts.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        PostCreateOutputBoundary presenter = new PostResponseFormatter();
        PostFactory postFactory = new PostFactory();
        PostCreateInputBoundary interactor = new PostCreateInteractor(
                post, presenter, postFactory);
        PostController postController = new PostController(
                interactor
        );

        // Build the GUI, plugging in the parts
        String username = "kevin";
        PostCreationPage postCreationPage = new PostCreationPage(username, postController);
        screens.add(postCreationPage, "post");
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
