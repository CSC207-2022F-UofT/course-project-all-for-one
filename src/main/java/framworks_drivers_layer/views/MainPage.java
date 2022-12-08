package framworks_drivers_layer.views;


import Interface_adapters_layer.controller.RecommendationController;
import Interface_adapters_layer.controller.SearchController;
import Interface_adapters_layer.presenter.*;
import application_business_rules_layer.recommendationUseCases.RecommendationInputBoundry;
import application_business_rules_layer.recommendationUseCases.RecommendationInteractor;
import application_business_rules_layer.recommendationUseCases.RecommendationOutputBoundry;
import application_business_rules_layer.searchUseCases.SearchOutputBoundary;
import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import enterprise_business_rules_layer.postEntities.Post;
import enterprise_business_rules_layer.postEntities.PostFactory;
import framworks_drivers_layer.dataAccess.FileOrder;
import framworks_drivers_layer.dataAccess.FilePost;
import application_business_rules_layer.postUseCases.PostDsGateway;
import application_business_rules_layer.postUseCases.PostInputBoundary;
import application_business_rules_layer.postUseCases.PostInteractor;
import application_business_rules_layer.postUseCases.PostOutputBoundary;
import application_business_rules_layer.recommendationUseCases.RecommendationResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class MainPage extends JPanel implements ActionListener {

    String username;
    JTextField searchKeywordsTextField = new JTextField(20);

    /**
     *
     * @param username username of the user that is acting
     */
    public MainPage(String username){


        this.username = username;

        //create the structure of main page
        JLabel title =new JLabel("Main Page");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        //create buttons for recommendation, profile, and search
        JButton recommendationButton = new JButton("Recommendation");
        JButton userCenterButton = new JButton("User Center");
        JButton searchButton = new JButton("Search");
        JButton addPostButton = new JButton("Add Post");

        JPanel buttons = new JPanel();
        buttons.add(recommendationButton);
        buttons.add(userCenterButton);
        buttons.add(addPostButton);


        //search module
        JPanel searchPanel = new JPanel();
        JLabel searchLabel = new JLabel("You want to search:");
        searchPanel.add(searchLabel);
        searchPanel.add(searchKeywordsTextField);
        searchPanel.add(searchButton);



        recommendationButton.addActionListener(this);
        userCenterButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserCenterPage userCenterPage = new UserCenterPage(username);

            }
        });

        searchButton.addActionListener(this);

        addPostButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame application = new JFrame("Post Example");
                CardLayout cardLayout = new CardLayout();
                JPanel screens = new JPanel(cardLayout);
                application.add(screens);

                PostDsGateway post;
                try {
                    post = new FilePost("./posts.csv");
                } catch (IOException error) {
                    throw new RuntimeException("Could not create file.");
                }
                PostOutputBoundary presenter = new PostResponsePresenter();
                PostFactory postFactory = new PostFactory();
                PostInputBoundary interactor = new PostInteractor(
                        post, presenter, postFactory);
                PostController postController = new PostController(
                        interactor
                );
                PostCreationPage postCreationPage = new PostCreationPage(username, postController);

                screens.add(postCreationPage, "post");
                cardLayout.show(screens, "post");
                application.pack();
                application.setVisible(true);
                application.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                application.setLocation(600, 300);
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(searchPanel);
        this.add(buttons);

    }


    /**
     *
     * @param e the event to be processed
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Recommendation")){
            try{
                RecommendationOutputBoundry recommendationOutputBoundry = new RecommendationResponsePresenter();

                PostDsGateway post;
                try {
                    post = new FilePost("./posts.csv");
                } catch (IOException error) {
                    throw new RuntimeException("Could not create posts.csv.");
                }

                RecommendationInputBoundry recommendationInputBoundry = new RecommendationInteractor(recommendationOutputBoundry, post);
                OrderDsGateway orderDsGateway;
                try{
                    orderDsGateway = new FileOrder("./orders.csv");
                } catch (IOException error){
                    throw new RuntimeException("Could not create orders.csv");
                }

                RecommendationController recommendationController = new RecommendationController(username,
                        recommendationInputBoundry, orderDsGateway);
                RecommendationResponseModel responseModel = recommendationController.generate();

                RecommendationPage recommendationPage = new RecommendationPage(responseModel, username);

            } catch (RecommendationFailedError error) {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }



        } else if(e.getActionCommand().equals("Search")){
            try{
                SearchOutputBoundary searchOutputBoundary = new SearchFormatterOutputBoundary();
                PostDsGateway postDsGateway;
                try {
                    postDsGateway = new FilePost("./posts.csv");
                } catch (IOException exception) {
                    throw new RuntimeException("Could not create posts.csv.");
                }
                SearchController searchController = new SearchController(postDsGateway, searchOutputBoundary);
                List<Post> posts = searchController.create(searchKeywordsTextField.getText());
                SearchPage searchPage = new SearchPage(username, posts);
            } catch (SearchFailureError error){
                JOptionPane.showMessageDialog(this, error.getMessage());
            }
        }
    }
}
