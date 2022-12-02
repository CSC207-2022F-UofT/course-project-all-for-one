package framworks_drivers_layer.views;

import application_business_rules_layer.messageUseCases.MessageDsGateway;
import enterprise_business_rules_layer.postEntities.Post;
import framworks_drivers_layer.dataAccess.FileMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class SearchPage implements ActionListener{
    private final String username;

    private final List<Post> posts ;
    public SearchPage(String username, List<Post> posts){
        this.username = username;
        this.posts = posts;
        JFrame searchFrame = new JFrame("Search Page");
        searchFrame.setBounds(400, 300, 400, 300);


        JPanel searScrollPanelViewPort = new JPanel();
        searScrollPanelViewPort.setLayout(new BoxLayout(searScrollPanelViewPort, BoxLayout.Y_AXIS));
        JButton[] buttonsAdded = new JButton[posts.size()];
        for(int j = 0; j < posts.size(); j++){
            JPanel jp1 = new JPanel();
            buttonsAdded[j] = new JButton("Open post" + j);
            buttonsAdded[j].addActionListener(this);
            jp1.add(new JLabel(posts.get(j).getTitle()));
            jp1.add(new JLabel(posts.get(j).getDescription()));
            jp1.add(new JLabel(String.valueOf(posts.get(j).getPrice())));
            jp1.add(buttonsAdded[j]);
            searScrollPanelViewPort.add(jp1);
        }
        JScrollPane searchScrollPanel = new JScrollPane(searScrollPanelViewPort, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        searchScrollPanel.setViewportView(searScrollPanelViewPort);
        searchFrame.add(searchScrollPanel);
        searchFrame.setVisible(true);
        searchFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int j = Integer.parseInt(String.valueOf(e.getActionCommand().charAt(e.getActionCommand().length()-1)));
        MessageDsGateway Messages = new FileMessage("./MessageBoard.csv");
        JFrame postPage = new PostPage(posts.get(j), username, Messages);
        postPage.setVisible(true);

    }
}
