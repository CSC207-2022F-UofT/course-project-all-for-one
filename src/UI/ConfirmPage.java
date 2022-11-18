//package UI;
//
//import controller.TradeController;
//import use_case.TradeRequestModel;
//import entity.Post;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class ConfirmPage extends JPanel implements ActionListener {
//
//    JTextField name = new JTextField(20);
//
//    JTextField phone = new JTextField(20);
//
//    JTextField address = new JTextField(100);
//
//    String number = Post.getNumber();
//
//    TradeController tradeController;
//
//    public ConfirmPage(String number, TradeController controller) {
//
//        this.tradeController = controller;
//
//        this.number = number;
//
//        JLabel title = new JLabel("Confirm Your Purchase");
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        LabelTextPanel nameInfo = new LabelTextPanel(
//                new JLabel("Enter Your Name"), name);
//        LabelTextPanel phoneInfo = new LabelTextPanel(
//                new JLabel("Enter Your Phone Number"), phone);
//        LabelTextPanel addressInfo = new LabelTextPanel(
//                new JLabel("Enter Your Address"), address);
//
//        JButton pay = new JButton("Pay");
//        JButton cancel = new JButton("Cancel");
//
//        JPanel buttons = new JPanel();
//        buttons.add(pay);
//        buttons.add(cancel);
//
//        pay.addActionListener(this);
//        cancel.addActionListener(this);
//
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        this.add(title);
//        this.add(nameInfo);
//        this.add(phoneInfo);
//        this.add(addressInfo);
//        this.add(buttons);
//    }
//
//
//
//    public void actionPerformed(ActionEvent evt) {
//        System.out.println("Click " + evt.getActionCommand());
//
//        TradeController.create(number);
//
//    }
//}
