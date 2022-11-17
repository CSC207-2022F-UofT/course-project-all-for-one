package UI;

import controller.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage implements ActionListener{
       JFrame frame = new JFrame();
       JLabel label = new JLabel();


       JButton Edit = Button.getEdit();
       JButton Wallet = Button.getWallet();
       JButton PurchaseHistory = Button.getPurchaseHistory();
       JButton PostHistory = Button.getPostHistory();
       JButton MessageBoard = Button.getMessageBoard();
       JButton BrowsingHistory = Button.getBrowsingHistory();
      //JButton Edit = new JButton("Edit/Create");
      //JButton Wallet = new JButton("Wallet");
      //JButton PurchaseHistory = new JButton("Purchase History");
      //JButton PostHistory = new JButton("Post History");
      //JButton MessageBoard = new JButton("Message Board");
      //JButton BrowsingHistory = new JButton("Browsing History");


      public UserPage(){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(420,400);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.add(Edit);
            frame.add(Wallet);
            frame.add(PurchaseHistory);
            frame.add(PostHistory);
            frame.add(MessageBoard);
            frame.add(BrowsingHistory);
            frame.add(label);


            Edit.setBounds(100,100,80,50);
            Edit.setFocusable(false);
            Edit.addActionListener(this);

            Wallet.setBounds(100,200,80,50);
            Wallet.setFocusable(false);
            Wallet.addActionListener(this);

            PurchaseHistory.setBounds(100,300,80,50);
            PurchaseHistory.setFocusable(false);
            PurchaseHistory.addActionListener(this);

            PostHistory.setBounds(100,400,80,50);
            PostHistory.setFocusable(false);
            PostHistory.addActionListener(this);

            MessageBoard.setBounds(100,500,80,50);
            MessageBoard.setFocusable(false);
            MessageBoard.addActionListener(this);

            BrowsingHistory.setBounds(100,600,80,50);
            BrowsingHistory.setFocusable(false);
            BrowsingHistory.addActionListener(this);

      }

      @Override
      public void actionPerformed(ActionEvent e) {
           if (e.getSource() == Edit){
                  EditPage editPage = new EditPage();
            }
            //if (e.getSource() == Wallet){
            //}
            //if (e.getSource() == PurchaseHistory){

            //}
            //if (e.getSource() == PostHistory){
            //      PostHistoryPage postpage = new PostHistoryPage();
            //}
            //if (e.getSource() == MessageBoard){

            //}
            //if (e.getSource() == BrowsingHistory){

            //}
      }


}


