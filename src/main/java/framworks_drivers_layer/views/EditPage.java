package framworks_drivers_layer.views;

import application_business_rules_layer.profileUseCases.ProfileGateway;
import application_business_rules_layer.profileUseCases.ProfileRequestModel;
import framworks_drivers_layer.dataAccess.FileProfile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EditPage extends JFrame implements ActionListener{
    final String username;


    JTextField textage = new JTextField();
    JTextField textusername = new JTextField();
    JTextField textaddress = new JTextField();
    JTextField textdescription = new JTextField();
    JTextField textphone = new JTextField();
    JTextField textgender = new JTextField();
    JButton save = new JButton("save");

    JButton cancel = new JButton("cancel");


    public EditPage(String username){
        this.username = username;


        ProfileGateway profile;
        try {
            profile = new FileProfile("./profile.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create profile.csv.");
        }

        String age = profile.getAge(username);
        String gender = profile.getGender(username);
        String description = profile.getDescription(username);
        String address = profile.getAddress(username);
        String phone = profile.getPhone(username);



        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(420, 420);
        this.setLayout(new FlowLayout());
        this.setVisible(true);


        textage.setText(age);
        textusername.setText(username);
        textaddress.setText(address);
        textdescription.setText(description);
        textphone.setText(phone);
        textgender.setText(gender);


        textage.setPreferredSize(new Dimension(100,40));
        textusername.setPreferredSize(new Dimension(100,40));
        textaddress.setPreferredSize(new Dimension(100,40));
        textdescription.setPreferredSize(new Dimension(100,40));
        textphone.setPreferredSize(new Dimension(100,40));
        textgender.setPreferredSize(new Dimension(100,40));

        textusername.setFocusable(false);

        this.add(textusername);
        this.add(textage);
        this.add(textaddress);
        this.add(textdescription);
        this.add(textphone);
        this.add(textgender);

        save.addActionListener(this);
        cancel.addActionListener(this);


        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Please input your username"));
        panel1.add(textusername);


        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Please input your age"));
        panel2.add(textage);


        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Please input your address"));
        panel3.add(textaddress);


        JPanel panel4 = new JPanel();
        panel4.add(new JLabel("Please input your description"));
        panel4.add(textdescription);


        JPanel panel5 = new JPanel();
        panel5.add(new JLabel("Please input your phone-number"));
        panel5.add(textphone);

        JPanel panel7 = new JPanel();
        panel7.add(new JLabel("Please input your gender"));
        panel7.add(textgender);

        JPanel panel6 = new JPanel();
        panel6.add(cancel);
        panel6.add(save);


        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel7);
        this.add(panel6);

        this.setTitle("Profile");




    }


    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getSource() == save){
            this.dispose();

            ProfileGateway profile;
            try {
                profile = new FileProfile("./profile.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create profile.csv.");
            }
            ProfileRequestModel profileRequestModel = new ProfileRequestModel(username, textage.getText(),textgender.getText(),
                    textaddress.getText(),textdescription.getText(),textphone.getText());
            profile.save(profileRequestModel);




            UserCenterPage userCenterPage = new UserCenterPage(username);

        }
        if (evt.getSource() == cancel){
            this.dispose();
            UserCenterPage userCenterPage = new UserCenterPage(username);

        }

    }
}
