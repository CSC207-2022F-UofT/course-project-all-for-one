package framworks_drivers_layer.views;


import enterprise_business_rules_layer.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserCenterPage implements ActionListener{
        private final String username;
       JFrame frame = new JFrame();
       JLabel label = new JLabel();


       JButton Edit = framworks_drivers_layer.views.Button.getEdit();
       JButton Wallet = framworks_drivers_layer.views.Button.getWallet();
       JButton PurchaseHistory = framworks_drivers_layer.views.Button.getPurchaseHistory();
       JButton PostHistory = framworks_drivers_layer.views.Button.getPostHistory();
       JButton BrowsingHistory = Button.getBrowsingHistory();
      //JButton Edit = new JButton("Edit/Create");
      //JButton Wallet = new JButton("Wallet");
      //JButton PurchaseHistory = new JButton("Purchase History");
      //JButton PostHistory = new JButton("Post History");
      //JButton MessageBoard = new JButton("Message Board");
      //JButton BrowsingHistory = new JButton("Browsing History");


      public UserCenterPage(String username){
            this.username = username;
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setBounds(600, 300, 420,400);
            frame.setLayout(new FlowLayout());
            frame.setVisible(true);
            frame.add(Edit);
            frame.add(Wallet);
            frame.add(PurchaseHistory);
            frame.add(PostHistory);
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

            BrowsingHistory.setBounds(100,600,80,50);
            BrowsingHistory.setFocusable(false);
            BrowsingHistory.addActionListener(this);

            JPanel panel1 = new JPanel();
            TextArea profileArea = new TextArea(Profile.getAge() + Profile.getUsername()+ Profile.getAddress() +
                    Profile.getDescription() + Profile.getPhone());
            panel1.add(profileArea);

            frame.add(panel1);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
           if (e.getSource() == Edit){
                  EditPage editPage = new EditPage();
                  frame.dispose();
            }
            //if (e.getSource() == Wallet){
            //}
            //if (e.getSource() == PurchaseHistory){

            //}
            //if (e.getSource() == PostHistory){
            //      PostHistoryPage postpage = new PostHistoryPage();
            //}
            //if (e.getSource() == BrowsingHistory){

            //}
      }


}


