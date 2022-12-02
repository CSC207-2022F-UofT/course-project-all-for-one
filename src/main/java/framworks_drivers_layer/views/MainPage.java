package framworks_drivers_layer.views;


import Interface_adapters_layer.controller.RecommendationController;
import Interface_adapters_layer.controller.SearchController;
import enterprise_business_rules_layer.postEntities.Post;
import enterprise_business_rules_layer.postEntities.PostFactory;
import framworks_drivers_layer.dataAccess.FilePost;
import application_business_rules_layer.postcreateUseCases.PostCreateDsGateway;
import Interface_adapters_layer.presenter.RecommendationFailedError;
import Interface_adapters_layer.presenter.SearchFailureError;
import Interface_adapters_layer.presenter.SearchFormatterPresenter;
import Interface_adapters_layer.presenter.SearchPresenter;
import application_business_rules_layer.postcreateUseCases.PostCreateInputBoundary;
import application_business_rules_layer.postcreateUseCases.PostCreateInteractor;
import application_business_rules_layer.postcreateUseCases.PostCreateOutputBoundary;
import application_business_rules_layer.recommendationUseCases.RecommendationResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class MainPage extends JPanel implements ActionListener {

    String username;
    RecommendationController recommendationController;
    JTextField searchKeywordsTextField = new JTextField(20);

    /**
     *
     * @param username username of the user that is acting
     * @param recommendationController the RecommendationController that would control which use case to use in this page
     */
    public MainPage(String username, RecommendationController recommendationController){

        this.recommendationController = recommendationController;

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
//        recommendationButton.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Click" + e.getActionCommand());
//
//                try{
//                    RecommendationResponseModel responseModel = recommendationController.generate();
//                } catch(RecommmendationFailedError error){
//                    JOptionPane.showMessageDialog(, "Please use more to have recommendation");
//
//                }
//            }
//        });
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

                PostCreateDsGateway post;
                try {
                    post = new FilePost("./posts.csv");
                } catch (IOException error) {
                    throw new RuntimeException("Could not create file.");
                }
                PostCreateOutputBoundary presenter = new PostResponseFormatter();
                PostFactory postFactory = new PostFactory();
                PostCreateInputBoundary interactor = new PostCreateInteractor(
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
                RecommendationResponseModel responseModel = recommendationController.generate();

                RecommendationPage recommendationPage = new RecommendationPage(responseModel, username);

            } catch (RecommendationFailedError error) {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }



        } else if(e.getActionCommand().equals("Search")){
            try{
                SearchPresenter searchPresenter = new SearchFormatterPresenter();
                PostCreateDsGateway postDsGateway;
                try {
                    postDsGateway = new FilePost("./posts.csv");
                } catch (IOException exception) {
                    throw new RuntimeException("Could not create posts.csv.");
                }
                SearchController searchController = new SearchController(postDsGateway, searchPresenter);
                List<Post> posts = searchController.create(searchKeywordsTextField.getText());
                SearchPage searchPage = new SearchPage(username, posts);
            } catch (SearchFailureError error){
                JOptionPane.showMessageDialog(this, error.getMessage());
            }
        }
    }
}
