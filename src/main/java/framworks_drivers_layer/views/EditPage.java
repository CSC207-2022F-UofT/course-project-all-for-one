package framworks_drivers_layer.views;

import enterprise_business_rules_layer.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPage extends JFrame implements ActionListener{
     String age = Profile.getAge();
    static String username = Profile.getUsername();
    static String description = Profile.getDescription();
    static String address = Profile.getAddress();
    static String phone = Profile.getPhone();

    static String gender = Profile.getGender();


    JTextField textage = new JTextField();
    JTextField textusername = new JTextField();
    JTextField textaddress = new JTextField();
    JTextField textdescription = new JTextField();
    JTextField textphone = new JTextField();
    JTextField textgender = new JTextField();
    JFrame frame = new JFrame();
    JButton save = new JButton("save");

    JButton cancel = new JButton("cancel");

    public EditPage(){

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);


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

        this.add(textage);
        this.add(textusername);
        this.add(textaddress);
        this.add(textdescription);
        this.add(textphone);
        this.add(textgender);

        save.addActionListener(this);
        cancel.addActionListener(this);


        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Please input your age"));
        panel1.add(textage);


        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Please input your username"));
        panel2.add(textusername);


        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Please input your address"));
        panel3.add(textaddress);


        JPanel panel4 = new JPanel();
        panel4.add(new JLabel("Please input your description"));
        panel4.add(textdescription);


        JPanel panel5 = new JPanel();
        panel5.add(new JLabel("Please input your phone-number"));
        panel5.add(textphone);

        JPanel panel6 = new JPanel();
        panel6.add(cancel);
        panel6.add(save);

        JPanel panel7 = new JPanel();
        panel7.add(new JLabel("Please input your gender"));

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel7);
        frame.add(panel6);

        frame.setTitle("Profile");




    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
        if (e.getSource() == save){
            frame.dispose();
            UserCenterPage userCenterPage = new UserCenterPage(username);
        }
        if (e.getSource() == cancel){
            UserCenterPage userCenterPage = new UserCenterPage(username);
            frame.dispose();
        }

    }
}
