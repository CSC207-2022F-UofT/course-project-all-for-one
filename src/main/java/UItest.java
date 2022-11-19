import presenter.RecommmendationFailedError;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UItest {
    public static void main(String[] args) {
        //jFrame setup
        JFrame jf = new JFrame("main");
        jf.setBounds(400, 300, 400, 300);

        JLabel title =new JLabel("Main Page");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //search module
        JPanel searchPanel = new JPanel();
        JLabel searchLabel = new JLabel("You want to search:");
        searchPanel.add(searchLabel);
        JTextField searchKeywordsTextField = new JTextField(20);
        searchPanel.add(searchKeywordsTextField);

        //create Jpanel containing buttons for recommendation, profile, and search
        JButton recommendationButton = new JButton("Recommendation");
        JButton profileButton = new JButton("Profile");
        JButton searchButton = new JButton("Search");

        JPanel buttons = new JPanel();
        buttons.add(recommendationButton);
        buttons.add(profileButton);
        buttons.add(searchButton);

        buttons.setLocation(100, 200);

        //assign functions to recommendationButton
        recommendationButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecommmendationFailedError error = new RecommmendationFailedError("use more to get recommendation");
                JOptionPane.showMessageDialog(jf, error.getMessage());
            }
        });

        //add to JFrame

        JPanel everything = new JPanel();
        everything.add(title);
        everything.add(searchPanel);
        everything.add(buttons);
        everything.setLayout(new BoxLayout(everything, BoxLayout.Y_AXIS));

        jf.add(everything);



        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
