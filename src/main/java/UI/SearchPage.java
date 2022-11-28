package UI;

import entities.Post;

import javax.swing.*;
import java.util.List;


public class SearchPage {
    private final String username;
    public SearchPage(String username, List<Post> posts){
        this.username = username;

        JFrame searchFrame = new JFrame("Search Page");
        searchFrame.setBounds(400, 300, 400, 300);

        JScrollPane searchScrollPanel = new JScrollPane();
        JPanel searScrollPanelViewPort = new JPanel();

        JButton[] buttonsAdded = new JButton[posts.size()];
        for(int j = 0; j < posts.size(); j++){
            JPanel jp1 = new JPanel();
            buttonsAdded[j] = new JButton("Open post" + j);
            jp1.add(new JLabel(posts.get(j).getTitle()));
            jp1.add(new JLabel(posts.get(j).getDescription()));
            jp1.add(new JLabel(String.valueOf(posts.get(j).getPrice())));
            jp1.add(buttonsAdded[j]);
            searScrollPanelViewPort.add(jp1);
        }

        searchScrollPanel.setViewportView(searScrollPanelViewPort);
        searchFrame.add(searchScrollPanel);
        searchFrame.setVisible(true);
        searchFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
