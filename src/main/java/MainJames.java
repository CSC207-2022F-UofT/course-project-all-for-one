import UI.*;
import entities.Post;
import entities.PostFactory;
import entities.Recommendation;
import gateway.FilePost;
import gateway.PostDsGateway;
import use_case.PostInputBoundary;
import use_case.PostInteractor;
import use_case.PostPresenter;
import use_case.RecommendationResponseModel;

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
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("sadf","iphone13", "good",  1300, tags);
        Post post2 = new Post("aswefwe","ipad pro", "take notes",  999, tags);
        Post post3 = new Post("sfdgz","airpods", "good sounding", 230, tags);
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);


        //assign functions to recommendationButton
        recommendationButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {



                Recommendation recommendation1 = new Recommendation(posts);
                RecommendationResponseModel responseModel = new RecommendationResponseModel(recommendation1);



                JFrame recommendationFrame = new JFrame("Recommendation");
                recommendationFrame.setBounds(500, 200, 500, 500);

                JPanel recommendationScrollPanelViewPort = new JPanel();
                recommendationScrollPanelViewPort.setLayout(new BoxLayout(recommendationScrollPanelViewPort, BoxLayout.Y_AXIS));




//                int j = 1;
//                if (responseModel.getRecommendation().getPosts().size() < 3){
//                    for(Post post: responseModel.getRecommendation().getPosts()){
//                        recommendationScrollPanel.add(new JLabel(post.getTitle()));
//
//                        recommendationScrollPanel.add(new JButton("Open post" + j));
//                    }
//
//                } else{
//                    JButton recomButton1 = new JButton("Open post 1");
//                    JButton recomButton2 = new JButton("Open post 2");
//                    JButton recomButton3 = new JButton("Open post 3");
//
//                    for(Post post: responseModel.getRecommendation().getPosts()){
//                        recommendationScrollPanel.add(new JLabel(post.getTitle()));
//                    }
//                    recommendationScrollPanel.add(recomButton1);
//                    recommendationScrollPanel.add(recomButton2);
//                    recommendationScrollPanel.add(recomButton3);
//
//
//                }


                JButton[] buttonsAdded = new JButton[responseModel.getRecommendation().getPosts().size()];
                for(int j = 0; j <responseModel.getRecommendation().getPosts().size(); j++){
                    JPanel jp1 = new JPanel();
                    buttonsAdded[j] = new JButton("Open post" + j);
                    jp1.add(new JLabel(responseModel.getRecommendation().getPosts().get(j).getTitle()));
                    jp1.add(new JLabel(responseModel.getRecommendation().getPosts().get(j).getDescription()));
                    jp1.add(new JLabel(String.valueOf(responseModel.getRecommendation().getPosts().get(j).getPrice())));
                    jp1.add(buttonsAdded[j]);
                    recommendationScrollPanelViewPort.add(jp1);
                }

                JScrollPane recommendationScrollPanel = new JScrollPane(recommendationScrollPanelViewPort, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                recommendationScrollPanel.setViewportView(recommendationScrollPanelViewPort);
                recommendationFrame.add(recommendationScrollPanel);
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
                PostPresenter presenter = new PostResponseFormatter();
                PostFactory postFactory = new PostFactory();
                PostInputBoundary interactor = new PostInteractor(
                        post, presenter, postFactory);
                PostController postController = new PostController(
                        interactor
                );
                PostScreen postScreen = new PostScreen("username", postController);

                screens.add(postScreen, "post");
                cardLayout.show(screens, "post");
                application.pack();
                application.setVisible(true);
                application.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            }
        });

        searchButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchPage searchPage = new SearchPage("username", posts);
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
