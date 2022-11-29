import enterprise_business_rules_layer.postEntities.Post;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainCecilia {
    public static void main(String[] args) {
        JFrame searchFrame = new JFrame("Search Page");
        searchFrame.setBounds(400, 300, 400, 300);


        JPanel searScrollPanelViewPort = new JPanel();
        searScrollPanelViewPort.setLayout(new BoxLayout(searScrollPanelViewPort, BoxLayout.Y_AXIS));

        ArrayList<String> tags = new ArrayList<>();
        tags.add(0, "xxx");
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("sadf","iphone13", "good",  1300, tags);
        Post post2 = new Post("aswefwe","ipad pro", "take notes",  999, tags);
        Post post3 = new Post("sfdgz","airpods", "good sounding", 230, tags);
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        List<JButton> buttonsAdded = new ArrayList<>();
        for(int j = 0; j < posts.size(); j++){
            buttonsAdded.add(new JButton("Open post" + j)) ;
            JPanel postPanel = new JPanel();
            postPanel.add(new JLabel(posts.get(j).getTitle()));
            postPanel.add(new JLabel(posts.get(j).getDescription()));
            postPanel.add(new JLabel(String.valueOf(posts.get(j).getPrice())));
            postPanel.add(buttonsAdded.get(j));
            searScrollPanelViewPort.add(postPanel);
        }

        JScrollPane searchScrollPanel = new JScrollPane(searScrollPanelViewPort,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        searchFrame.add(searchScrollPanel);
        searchFrame.setVisible(true);
        searchFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
