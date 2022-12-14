package framworks_drivers_layer.views;

import Interface_adapters_layer.controller.PostController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import static javax.swing.JOptionPane.showMessageDialog;

// Frameworks/Drivers layer

public class PostCreationPage extends JPanel implements ActionListener {
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
    public PostCreationPage(String username, PostController controller) {
        this.username = username;

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
                        post_description.getText().replaceAll("\\p{Punct}", ""),
                        price.getText(),
                        tags);
                showMessageDialog(this, "Your post" +" "+ post_title.getText() +" "+ "has been created.");
                post_title.setText(null);
                post_description.setText(null);
                price.setText(null);
                add_tag.setText(null);
                tags = new ArrayList<>();
                tag_show.setText(null);
            } catch (Exception e) {
                showMessageDialog(this, e.getMessage());
            }
        }
        else{
            String t = add_tag.getText();
            Boolean Duplicate = false;
            for (String tag : tags) {
                if (tag.equals(t)) {
                    Duplicate = true;
                    break;
                }
            }
            if (Duplicate) {
                showMessageDialog(this, "Duplicate tag");
            }
            else if(Objects.equals(t.strip(), "")){
                showMessageDialog(this, "Tag cannot be empty");
            }
            else if(!Objects.equals(t.strip(), "")){
                tags.add(t);
                String str_tags = tags.toString();
                str_tags = str_tags.replace("[","").replace("]","");
                tag_show.setText(str_tags);
            }



            add_tag.setText(null);
        }


    }
}