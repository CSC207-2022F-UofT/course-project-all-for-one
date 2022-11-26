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


        JButton[] buttonsAdded = new JButton[posts.size()];
        for(int j = 0; j < posts.size(); j++){
            buttonsAdded[j] = new JButton("Open post" + j);
            searchScrollPanel.add(new JLabel(posts.get(j).getTitle()));
            searchScrollPanel.add(new JLabel(posts.get(j).getDescription()));
            searchScrollPanel.add(new JLabel(String.valueOf(posts.get(j).getPrice())));
            searchScrollPanel.add(buttonsAdded[j]);
        }

        searchFrame.add(searchScrollPanel);
        searchFrame.setVisible(true);
        searchFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
