package UI;

import controller.UserLoginController;
import controller.UserRegisterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

// Frameworks/Drivers layer

public class UserLoginScreen extends JPanel implements ActionListener {
    /**
     * The username chosen by the user
     */
    JTextField username = new JTextField(15);
    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);

    /**
     * The controller
     */
    UserLoginController userLoginController;

    /**
     * A window with a title and a JButton.
     */
    public UserLoginScreen(UserLoginController controller) {

        this.userLoginController = controller;

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Enter username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Enter password"), password);

        JButton login = new JButton("Login");

        JPanel buttons = new JPanel();
        buttons.add(login);

        login.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try {
            userLoginController.create(username.getText(),
                    String.valueOf(password.getPassword()));
//            JOptionPane.showMessageDialog(this, "%s created.".formatted(username.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}