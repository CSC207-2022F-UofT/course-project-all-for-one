package framworks_drivers_layer.views;

import Interface_adapters_layer.controller.TradeController;
import Interface_adapters_layer.view_interfaces.TradeViewInterface;
import application_business_rules_layer.profileUseCases.ProfileGateway;
import application_business_rules_layer.tradeUseCases.TradeResponseModel;
import enterprise_business_rules_layer.postEntities.Post;
import framworks_drivers_layer.dataAccess.FileProfile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConfirmOrderPage extends JPanel implements ActionListener, TradeViewInterface {

    JTextField name = new JTextField(20);

    JTextField phone = new JTextField(20);

    JTextField address = new JTextField(100);

    public Post Post;


    public String buyerUsername;


    TradeController tradeController;

    public ConfirmOrderPage(Post post, String buyerUsername, TradeController tradeController) {

        this.tradeController = tradeController;
        this.Post = post;
        this.buyerUsername = buyerUsername;

        ProfileGateway profile;
        try {
            profile = new FileProfile("./profile.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        JLabel title = new JLabel("Confirm Your Purchase");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel dPost = new JLabel(Post.getTitle());
        dPost.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel dFinalPrice = new JLabel(Post.getPrice());
        dFinalPrice.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel dSeller = new JLabel(post.getUsername());
        dSeller.setAlignmentX(Component.CENTER_ALIGNMENT);

        name.setText(buyerUsername);
        phone.setText(profile.getPhone(buyerUsername));
        address.setText(profile.getAddress(buyerUsername));
        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel("Enter Your Name"), name);
        LabelTextPanel phoneInfo = new LabelTextPanel(
                new JLabel("Enter Your Phone Number"), phone);
        LabelTextPanel addressInfo = new LabelTextPanel(
                new JLabel("Enter Your Address"), address);

        JButton pay = new JButton("Pay");

        JPanel buttons = new JPanel();
        buttons.add(pay);

        pay.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(dPost);
        this.add(dFinalPrice);
        this.add(dSeller);
        this.add(nameInfo);
        this.add(phoneInfo);
        this.add(addressInfo);
        this.add(buttons);
    }

    @Override
    public void showSuccessMessage(TradeResponseModel responseModel){
        JOptionPane.showMessageDialog(this, responseModel.getSuccessMessage() + " at " +
                responseModel.getCreationTime());
    }


    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try {
            TradeResponseModel responseModel = tradeController.create(Post, name.getText(), phone.getText(),
                    address.getText(), buyerUsername);
            showSuccessMessage(responseModel);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
