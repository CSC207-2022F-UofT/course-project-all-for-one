package UI;

import controller.TradeController;
import entity.Account;
import entity.Post;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmPage extends JPanel implements ActionListener {

    JTextField name = new JTextField(20);

    JTextField phone = new JTextField(20);

    JTextField address = new JTextField(100);

    public Post Post;

    public String CreationTime;

    public Account Buyer;

    public Account Seller;


    TradeController tradeController;

    public ConfirmPage(Post post, String creationTime, Account buyer, Account seller,
                       TradeController tradeController) {

        this.tradeController = tradeController;

        this.Post = post;
        this.CreationTime = creationTime;
        this.Buyer = buyer;
        this.Seller = seller;


        JLabel title = new JLabel("Confirm Your Purchase");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel dPost = new JLabel(Post.getTitle());
        dPost.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel dFinalPrice = new JLabel(Double.toString(Post.get_price()));
        dFinalPrice.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel dCreationTime = new JLabel(CreationTime);
        dCreationTime.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel dSeller = new JLabel(Seller.getUsername());
        dSeller.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        pay.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(dPost);
        this.add(dFinalPrice);
        this.add(dCreationTime);
        this.add(dSeller);
        this.add(nameInfo);
        this.add(phoneInfo);
        this.add(addressInfo);
        this.add(buttons);
    }


    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try {
            TradeController.create(Post, CreationTime,
                    name.getText(), address.getText(), phone.getText(), Buyer, Seller);
            JOptionPane.showMessageDialog(this, "Order Placed");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
