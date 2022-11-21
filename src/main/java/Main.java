import entity.Post;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        JFrame jf =new JFrame();
        jf.setBounds(400, 300, 400, 300);
        jf.setLayout(new FlowLayout());

        JTextField add = new JTextField(15);
        JTextField added = new JTextField(15);
        JButton jb1 = new JButton("add tag");
        jb1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                added.setText(add.getText());
            }
        });

        JPanel jp = new JPanel();
        jp.add(add);
        jp.add(jb1);

        jf.add(jp);
        jf.add(added);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        LinkedList<Post> posts = new LinkedList<>();
        for(Post post : posts){

        }

    }

}
