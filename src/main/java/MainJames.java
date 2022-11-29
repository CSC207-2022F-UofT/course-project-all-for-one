import framworks_drivers_layer.views.PostController;
import framworks_drivers_layer.views.PostResponseFormatter;
import framworks_drivers_layer.views.PostCreationPage;
import framworks_drivers_layer.views.UserCenterPage;
import enterprise_business_rules_layer.postEntities.Post;
import enterprise_business_rules_layer.postEntities.PostFactory;
import enterprise_business_rules_layer.Recommendation;
import framworks_drivers_layer.dataAccess.FilePost;
import application_business_rules_layer.postUseCases.PostDsGateway;
import application_business_rules_layer.postUseCases.PostInputBoundary;
import application_business_rules_layer.postUseCases.PostInteractor;
import application_business_rules_layer.postUseCases.PostOutputBoundary;
import application_business_rules_layer.recommendationUseCases.RecommendationResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainJames {
    public static void main(String[] args) {
        //jFrame setup
        JFrame jf = new JFrame("main");
        jf.setBounds(400, 300, 600, 300);

        JLabel title =new JLabel("Main Page");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //create buttons for recommendation, profile, and search
        JButton recommendationButton = new JButton("Recommendation");
        JButton userCenterButton = new JButton("User Center");
        JButton searchButton = new JButton("Search");
        JButton addPostButton = new JButton("Add Post");

        //search module
        JPanel searchPanel = new JPanel();
        JLabel searchLabel = new JLabel("You want to search:");
        searchPanel.add(searchLabel);
        JTextField searchKeywordsTextField = new JTextField(20);
        searchPanel.add(searchKeywordsTextField);
        searchPanel.add(searchButton);



        //put buttons into a panel
        JPanel buttons = new JPanel();
        buttons.add(recommendationButton);
        buttons.add(userCenterButton);
        buttons.add(addPostButton);

        buttons.setLocation(100, 200);


        ArrayList<String> tags = new ArrayList<>();
        tags.add(0, "xxx");
        //assign functions to recommendationButton
        recommendationButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Post> posts = new ArrayList<>();
                Post post1 = new Post("sadf","iphone13", "good",  1300, tags);
                Post post2 = new Post("aswefwe","ipad pro", "take notes",  999, tags);
                Post post3 = new Post("sfdgz","airpods", "good sounding", 230, tags);
                posts.add(post1);
                posts.add(post2);
                posts.add(post3);

                Recommendation recommendation1 = new Recommendation(posts);
                RecommendationResponseModel responseModel = new RecommendationResponseModel(recommendation1);




                JPanel recommendationPanel = new JPanel();
                recommendationPanel.setLayout(new BoxLayout(recommendationPanel, BoxLayout.Y_AXIS));

                JFrame recommendationFrame = new JFrame("Recommendation");
                recommendationFrame.setBounds(500, 200, 300, 500);




//                int j = 1;
//                if (responseModel.getRecommendation().getPosts().size() < 3){
//                    for(Post post: responseModel.getRecommendation().getPosts()){
//                        recommendationPanel.add(new JLabel(post.getTitle()));
//
//                        recommendationPanel.add(new JButton("Open post" + j));
//                    }
//
//                } else{
//                    JButton recomButton1 = new JButton("Open post 1");
//                    JButton recomButton2 = new JButton("Open post 2");
//                    JButton recomButton3 = new JButton("Open post 3");
//
//                    for(Post post: responseModel.getRecommendation().getPosts()){
//                        recommendationPanel.add(new JLabel(post.getTitle()));
//                    }
//                    recommendationPanel.add(recomButton1);
//                    recommendationPanel.add(recomButton2);
//                    recommendationPanel.add(recomButton3);
//
//
//                }
                JButton[] buttonsAdded = new JButton[responseModel.getRecommendation().getPosts().size()];
                for(int j = 0; j <responseModel.getRecommendation().getPosts().size(); j++){
                    buttonsAdded[j] = new JButton("Open post" + j);
                    recommendationPanel.add(new JLabel(responseModel.getRecommendation().getPosts().get(j).getTitle()));
                    recommendationPanel.add(new JLabel(responseModel.getRecommendation().getPosts().get(j).getDescription()));
                    recommendationPanel.add(new JLabel(String.valueOf(responseModel.getRecommendation().getPosts().get(j).getPrice())));
                    recommendationPanel.add(buttonsAdded[j]);
                }

                recommendationFrame.add(recommendationPanel);
                recommendationFrame.setVisible(true);
                recommendationFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//                JOptionPane.showMessageDialog(jf, "Use more to have recommendation!");
            }
        });
        userCenterButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserCenterPage userCenterPage = new UserCenterPage("username");
            }
        });
        //add to JFrame
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
                PostOutputBoundary presenter = new PostResponseFormatter();
                PostFactory postFactory = new PostFactory();
                PostInputBoundary interactor = new PostInteractor(
                        post, presenter, postFactory);
                PostController postController = new PostController(
                        interactor
                );
                PostCreationPage postCreationPage = new PostCreationPage("username", postController);

                screens.add(postCreationPage, "post");
                cardLayout.show(screens, "post");
                application.pack();
                application.setVisible(true);
                application.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            }
        });

        JPanel everything = new JPanel();
        everything.add(title);
        everything.add(searchPanel);
        everything.add(buttons);
        everything.setLayout(new BoxLayout(everything, BoxLayout.Y_AXIS));

        jf.add(everything);



        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
