package UI;


import controller.RecommendationController;
import entity.Post;
import presenter.RecommmendationFailedError;
import useCase.RecommendationResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class MainPage extends JPanel implements ActionListener {

    String username;
    RecommendationController recommendationController;
    JTextField searchKeywordsTextField = new JTextField(20);


    public MainPage(String username, RecommendationController recommendationController){

        this.recommendationController = recommendationController;

        this.username = username;

        //create the structure of main page
        JLabel title =new JLabel("Main Page");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel searchPanel = new JPanel();
        JLabel searchLabel = new JLabel("You want to search:");
        searchPanel.add(searchLabel);
        searchPanel.add(searchKeywordsTextField);

        //create buttons for recommendation, profile, and search
        JButton recommendationButton = new JButton("Recommendation");
        JButton profileButton = new JButton("Profile");
        JButton searchButton = new JButton("Search");

        JPanel buttons = new JPanel();
        buttons.add(recommendationButton);
        buttons.add(profileButton);
        buttons.add(searchButton);

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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(searchPanel);
        this.add(buttons);

    }




    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("recommendationButton")){
            try{
                RecommendationResponseModel responseModel = recommendationController.generate();

                JScrollPane recom = new JScrollPane();

                int j = 1;
                if (Array.getLength(responseModel.getRecommendation().getPosts()) < 3){
                    for(Post post: responseModel.getRecommendation().getPosts()){
                        recom.add(new JLabel(post.getTitle()));
                        recom.add(new JButton("Open post" + j));
                    }
                } else{
                    for (int i = 0; i < 3; i++) {
                        for(Post post: responseModel.getRecommendation().getPosts()){
                            recom.add(new JLabel(post.getTitle()));
                            recom.add(new JButton("Open post" + i));
                        }
                    }
                }




            } catch (RecommmendationFailedError error) {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }


        } //else if search, profile
    }
}
