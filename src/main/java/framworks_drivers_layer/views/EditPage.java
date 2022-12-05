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


    JTextField textAge = new JTextField();
    JTextField textUsername = new JTextField();
    JTextField textAddress = new JTextField();
    JTextField textDescription = new JTextField();
    JTextField textPhone = new JTextField();
    JTextField textGender = new JTextField();
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


        textAge.setText(age);
        textUsername.setText(username);
        textAddress.setText(address);
        textDescription.setText(description);
        textPhone.setText(phone);
        textGender.setText(gender);


        textAge.setPreferredSize(new Dimension(100,40));
        textUsername.setPreferredSize(new Dimension(100,40));
        textAddress.setPreferredSize(new Dimension(100,40));
        textDescription.setPreferredSize(new Dimension(100,40));
        textPhone.setPreferredSize(new Dimension(100,40));
        textGender.setPreferredSize(new Dimension(100,40));

        textUsername.setFocusable(false);

        this.add(textUsername);
        this.add(textAge);
        this.add(textAddress);
        this.add(textDescription);
        this.add(textPhone);
        this.add(textGender);

        save.addActionListener(this);
        cancel.addActionListener(this);


        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Please input your username"));
        panel1.add(textUsername);


        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Please input your age"));
        panel2.add(textAge);


        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Please input your address"));
        panel3.add(textAddress);


        JPanel panel4 = new JPanel();
        panel4.add(new JLabel("Please input your description"));
        panel4.add(textDescription);


        JPanel panel5 = new JPanel();
        panel5.add(new JLabel("Please input your phone-number"));
        panel5.add(textPhone);

        JPanel panel7 = new JPanel();
        panel7.add(new JLabel("Please input your gender"));
        panel7.add(textGender);

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
            ProfileRequestModel profileRequestModel = new ProfileRequestModel(username, textAge.getText(), textGender.getText(),
                    textAddress.getText(), textDescription.getText(), textPhone.getText());
            profile.save(profileRequestModel);




            UserCenterPage userCenterPage = new UserCenterPage(username);

        }
        if (evt.getSource() == cancel){
            this.dispose();
            UserCenterPage userCenterPage = new UserCenterPage(username);

        }

    }
}
