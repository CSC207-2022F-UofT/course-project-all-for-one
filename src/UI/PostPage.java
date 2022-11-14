package UI;

import controller.BuyController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostPage extends JPanel implements ActionListener {

    String number = Post.getNumber();

    BuyController buyController;

    public PostPage(BuyController controller) {

        this.buyController = controller;

        JButton buy = new JButton("Buy");

        JPanel buttons = new JPanel();
        buttons.add(buy);

        buy.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(buttons);
    }


    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());


        buyController.create(number);


        }
    }
