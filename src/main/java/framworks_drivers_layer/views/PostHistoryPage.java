package framworks_drivers_layer.views;

import application_business_rules_layer.messageUseCases.MessageDsGateway;
import enterprise_business_rules_layer.postEntities.Post;
import framworks_drivers_layer.dataAccess.FileMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PostHistoryPage extends JFrame implements ActionListener {
    private final String username;

    private final List<Post> posts ;
    public PostHistoryPage(String username, List<Post> posts){
        this.username = username;
        this.posts = posts;

        this.setBounds(400, 300, 400, 300);


        JPanel postScrollPanelViewPort = new JPanel();
        postScrollPanelViewPort.setLayout(new BoxLayout(postScrollPanelViewPort, BoxLayout.Y_AXIS));
        JButton[] buttonsAdded = new JButton[posts.size()];
        for(int j = 0; j < posts.size(); j++){
            JPanel jp1 = new JPanel();
            jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
            buttonsAdded[j] = new JButton("Open post" + j);
            buttonsAdded[j].addActionListener(this);
            jp1.add(new JLabel("Title: " + posts.get(j).getTitle()));
            jp1.add(new JLabel("Description: " + posts.get(j).getDescription()));
            jp1.add(new JLabel("Price: " + posts.get(j).getPrice()));
            jp1.add(buttonsAdded[j]);
            postScrollPanelViewPort.add(jp1);
        }
        JScrollPane searchScrollPanel = new JScrollPane(postScrollPanelViewPort, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        searchScrollPanel.setViewportView(postScrollPanelViewPort);
        this.add(searchScrollPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int j = Integer.parseInt(String.valueOf(e.getActionCommand().charAt(e.getActionCommand().length()-1)));
        MessageDsGateway Messages = new FileMessage("./MessageBoard.csv");
        JFrame postPage = new PostPage(posts.get(j), username, Messages);
        postPage.setVisible(true);
        this.dispose();

    }
}