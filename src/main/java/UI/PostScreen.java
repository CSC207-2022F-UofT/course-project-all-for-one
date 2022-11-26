package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

// Frameworks/Drivers layer

public class PostScreen extends JPanel implements ActionListener {
    /**
     * The username chosen by the user
     */
    String username;
    JTextField post_title = new JTextField(15);
    /**
     * The password
     */
    JTextArea post_description = new JTextArea(5,15);
    /**
     * The second password to make sure the user understands
     */
    JTextField price = new JTextField(15);
    JTextField add_tag = new JTextField(15);
    ArrayList<String> tags = new ArrayList<String>();
    final JLabel tag_show = new JLabel();

    /**
     * The controller
     */
    PostController postController;

    /**
     * A window with a title and a JButton.
     */
    public PostScreen(String username, PostController controller) {

        this.postController = controller;

        JLabel title = new JLabel("Post Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel titleInfo = new LabelTextPanel(
                new JLabel("Title:"), post_title);
        LabelTextAreaPanel descriptionInfo = new LabelTextAreaPanel(
                new JLabel("Description:"), post_description);
        LabelTextPanel priceInfo = new LabelTextPanel(
                new JLabel("Price:"), price);

        JButton add = new JButton("add tag");
        TextPanelwithButton tagsInfo = new TextPanelwithButton(
                add_tag, add);

//        add.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                tags.add(add_tag.getText());
//                String str_tags = tags.toString();
//                str_tags = str_tags.replace("[","").replace("]","");
//                tag_show.setText(str_tags);
//            }
//        });

        JButton submit = new JButton("Submit");
        JPanel buttons = new JPanel();
        buttons.add(submit);

        submit.addActionListener(this);
        add.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(titleInfo);
        this.add(descriptionInfo);
        this.add(priceInfo);
        this.add(tagsInfo);
        this.add(tag_show);
        this.add(buttons);

        this.setVisible(true);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Submit")) {

            try {
                postController.create(username,
                        post_title.getText(),
                        String.valueOf(post_description.getText()),
                        Double.parseDouble(price.getText()),
                        tags);
                showMessageDialog(this, "Your post" +" "+ post_title.getText() + "has been created.");
            } catch (Exception e) {
                showMessageDialog(this, e.getMessage());
            }
        }
        else{
            tags.add(add_tag.getText());
            String str_tags = tags.toString();
            str_tags = str_tags.replace("[","").replace("]","");
            tag_show.setText(str_tags);
        }


    }
}