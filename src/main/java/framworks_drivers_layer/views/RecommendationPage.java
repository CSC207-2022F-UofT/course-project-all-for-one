package framworks_drivers_layer.views;

import application_business_rules_layer.messageUseCases.MessageDsGateway;
import application_business_rules_layer.recommendationUseCases.RecommendationResponseModel;
import enterprise_business_rules_layer.postEntities.Post;
import framworks_drivers_layer.dataAccess.FileMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RecommendationPage extends JFrame implements ActionListener {
    List<Post> posts;
    String username;
    public RecommendationPage(RecommendationResponseModel responseModel, String username){
        this.username = username;
        this.posts = responseModel.getRecommendation().getPosts();
        this.setName("Recommendation");
        this.setBounds(500, 200, 500, 500);


        JPanel recommendationScrollPanelViewPort = new JPanel();
        recommendationScrollPanelViewPort.setLayout(new BoxLayout(recommendationScrollPanelViewPort, BoxLayout.Y_AXIS));



        JButton[] buttonsAdded = new JButton[posts.size()];
        for(int j = 0; j < posts.size(); j++){
            JPanel jp1 = new JPanel();
            buttonsAdded[j] = new JButton("Open post" + j);
            buttonsAdded[j].addActionListener(this);
            jp1.add(new JLabel(responseModel.getRecommendation().getPosts().get(j).getTitle()));
            jp1.add(new JLabel(responseModel.getRecommendation().getPosts().get(j).getDescription()));
            jp1.add(new JLabel(String.valueOf(responseModel.getRecommendation().getPosts().get(j).getPrice())));
            jp1.add(buttonsAdded[j]);
            recommendationScrollPanelViewPort.add(jp1);
        }

        JScrollPane recommendationScrollPanel = new JScrollPane(recommendationScrollPanelViewPort, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        recommendationScrollPanel.setViewportView(recommendationScrollPanelViewPort);
        this.add(recommendationScrollPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int j = Integer.parseInt(String.valueOf(e.getActionCommand().charAt(e.getActionCommand().length()-1)));
        MessageDsGateway Messages = new FileMessage("./MessageBoard.csv");
        JFrame postPage = new PostPage(posts.get(j), username, Messages);
        postPage.setVisible(true);
    }
}
