package UI;

import Entity.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPage extends JPanel implements ActionListener{
    static String age = Profile.getAge();
    static String username = Profile.getUsername();
    static String description = Profile.getDescription();
    static String Address = Profile.getAddress();
    static String phone = Profile.getPhone();


    JTextField textage = new JTextField(3);
    JTextField textusername = new JTextField(20);
    JTextField textaddress = new JTextField(100);
    JTextField textdescription = new JTextField(200);
    JTextField textphone = new JTextField(20);

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Profile");


    public EditPage(){
       // label.setBounds(0,0,100,50);
        //label.setFont(new Font(null,Font.PLAIN,25));
       // frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);



        JLabel title = new JLabel("Confirm Your Profile" );
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton save = new JButton("save");
        JButton cancel = new JButton("cancel");

        JPanel buttons = new JPanel();
        buttons.add(save);
        buttons.add(cancel);

        JPanel main = new JPanel();

        save.addActionListener((ActionListener) this);
        cancel.addActionListener((ActionListener) this);

        LabelTextPanel ageinfo = new LabelTextPanel(new JLabel("Enter your age:"),textage);
        LabelTextPanel usernameinfo = new LabelTextPanel(new JLabel("Enter your usernmae:"), textusername);
        LabelTextPanel addressinfo = new LabelTextPanel(new JLabel("Enter your address:"), textaddress);
        LabelTextPanel descriptioninfro = new LabelTextPanel(new JLabel("Enter your description:"), textdescription);
        LabelTextPanel phoneinfo = new LabelTextPanel(new JLabel("Enter your phone:"), textphone);

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(ageinfo);
        main.add(usernameinfo);
        main.add(addressinfo);
        main.add(descriptioninfro);
        main.add(phoneinfo);
        main.add(buttons);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(ageinfo);
        this.add(usernameinfo);
        this.add(addressinfo);
        this.add(descriptioninfro);
        this.add(phoneinfo);
        this.add(buttons);

        frame.getContentPane().add(main);
        frame.getContentPane().add(buttons);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());

    }
}
