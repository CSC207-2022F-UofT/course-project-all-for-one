package UI;

import Entity.Profile;

import javax.swing.*;
import java.awt.*;

public class EditPage {
    static int age = Profile.getAge();
    static String username = Profile.getUsername();
    static String description = Profile.getDescription();
    static String Address = Profile.getAddress();
    static String phone = Profile.getPhone();

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Profile");

    EditPage(){
        label.setBounds(0,0,100,50);
        label.setFont(new Font(null,Font.PLAIN,25));
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);


    }


}
