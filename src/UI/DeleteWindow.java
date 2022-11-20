package UI;

import javax.swing.*;
import java.awt.*;

public class DeleteWindow extends JFrame {
    JPanel mainPanel = new JPanel();
    JButton yes = new JButton("Yes");
    JButton no = new JButton("No");
    JLabel delete = new JLabel("Are you sure you want to delete this message?");

    public DeleteWindow() throws HeadlessException {
        JPanel deleteMessagePanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        deleteMessagePanel.add(delete);
        buttonPanel.add(no);
        buttonPanel.add(yes);


        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(deleteMessagePanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

    }

    public static void main(String[] args) {
        JFrame demo = new DeleteWindow();
        demo.setVisible(true);
    }
}
