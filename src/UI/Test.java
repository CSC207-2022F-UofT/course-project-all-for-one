package UI;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrame jf = new JFrame();

        JLabel title = new JLabel("Confirm Your Purchase");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField name = new JTextField(20);

        JTextField phone = new JTextField(20);

        JTextField address = new JTextField(100);

        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel("Enter Your Name"), name);
        LabelTextPanel phoneInfo = new LabelTextPanel(
                new JLabel("Enter Your Phone Number"), phone);
        LabelTextPanel addressInfo = new LabelTextPanel(
                new JLabel("Enter Your Address"), address);

        JButton pay = new JButton("Pay");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(pay);
        buttons.add(cancel);



        jf.setLayout(new BoxLayout(jf, BoxLayout.Y_AXIS));

        jf.add(title);
        jf.add(nameInfo);
        jf.add(phoneInfo);
        jf.add(addressInfo);
        jf.add(buttons);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
