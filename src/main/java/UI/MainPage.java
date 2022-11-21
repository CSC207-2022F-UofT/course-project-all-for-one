package UI;


import controller.RecommendationController;
import presenter.RecommmendationFailedError;
import useCase.RecommendationResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


        //create buttons for recommendation, profile, and search
        JButton recommendationButton = new JButton("Recommendation");
        JButton userCenterButton = new JButton("User Center");
        JButton searchButton = new JButton("Search");

        JPanel buttons = new JPanel();
        buttons.add(recommendationButton);
        buttons.add(userCenterButton);


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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(searchPanel);
        this.add(buttons);

    }




    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("recommendationButton")){
            try{
                RecommendationResponseModel responseModel = recommendationController.generate();

                JPanel recommendationPanel = new JPanel();
                recommendationPanel.setLayout(new BoxLayout(recommendationPanel, BoxLayout.Y_AXIS));

                JFrame recommendationFrame = new JFrame("Recommendation");
                recommendationFrame.setBounds(500, 200, 300, 500);

                Button[] buttonsAdded = new Button[responseModel.getRecommendation().getPosts().size()];
                for(int j = 0; j <responseModel.getRecommendation().getPosts().size(); j++){
                    buttonsAdded[j] = new Button("Open post" + j);
                    recommendationPanel.add(new JLabel(responseModel.getRecommendation().getPosts().get(j).getTitle()));
                    recommendationPanel.add(new JLabel(responseModel.getRecommendation().getPosts().get(j).getDescription()));
                    recommendationPanel.add(buttonsAdded[j]);
                }

                recommendationFrame.add(recommendationPanel);
                recommendationFrame.setVisible(true);
                recommendationFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);





            } catch (RecommmendationFailedError error) {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }


        } //else if search, profile
    }
}
