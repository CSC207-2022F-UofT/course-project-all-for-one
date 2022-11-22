package UI;

import entities.Post;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class BrowsingHistoryPage {
    public BrowsingHistoryPage(LinkedList<Post> posts){
        JFrame jf = new JFrame("Browsing History");
        jf.setLayout(new FlowLayout(FlowLayout.CENTER));
        jf.setBounds(400, 300, 300, 200);
        JMenuBar bar = new JMenuBar();
        for (Post post : posts) {
            JMenu menu = new JMenu(post.getTitle());
            JMenuItem item1 = new JMenuItem("Product: " + post.getTitle());
            JMenuItem item2 = new JMenuItem("Description: " + post.getDescription());
            JMenuItem item3 = new JMenuItem("Status: " + post.getStatus());
            JMenuItem item4 = new JMenuItem("Price: " + post.getPrice());
            JMenuItem item5 = new JMenuItem("Tag: " + post.getTagsString());
            JMenuItem item6 = new JMenuItem("Status: In Progress");
            menu.add(item1);
            menu.add(item2);
            menu.add(item3);
            menu.add(item4);
            menu.add(item5);
            menu.add(item6);
            bar.add(menu);
            jf.add(bar);
        }



        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


}
