package UI;

import entities.Post;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class BrowsingHistoryPage {
    public static void BrowsingHistoryPage(String[] args, LinkedList<Post> posts){
        JFrame jf = new JFrame("Browsing History");
        jf.setLayout(new FlowLayout(FlowLayout.CENTER));
        jf.setBounds(400, 300, 300, 200);
        JMenuBar bar = new JMenuBar();
        for (Post post : posts) {
            JMenu menu = new JMenu(post.get_title());
            JMenuItem item1 = new JMenuItem("Product: " + post.get_title());
            JMenuItem item2 = new JMenuItem("Description: " + post.get_description());
            JMenuItem item3 = new JMenuItem("Status: " + post.get_status());
            JMenuItem item4 = new JMenuItem("Price: " + post.get_price());
            JMenuItem item5 = new JMenuItem("Tag: " + Arrays.toString(post.get_tags()));
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
