package framworks_drivers_layer.views;


import Interface_adapters_layer.presenter.ProfilePresenter;
import application_business_rules_layer.profileUseCases.ProfileGateway;
import application_business_rules_layer.profileUseCases.ProfileRequestModel;
import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import application_business_rules_layer.userUseCases.UserDsGateway;
import enterprise_business_rules_layer.Profile;
import enterprise_business_rules_layer.PurchaseHistory;
import enterprise_business_rules_layer.Wallet;
import framworks_drivers_layer.dataAccess.FileOrder;
import framworks_drivers_layer.dataAccess.FileProfile;
import framworks_drivers_layer.dataAccess.FileUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserCenterPage extends JFrame implements ActionListener{
      private final String username;



      public UserCenterPage(String username) {
            this.username = username;

            JButton Edit = new JButton("Edit/Create");
            JButton Wallet = new JButton("Wallet");
            JButton PurchaseHistory = new JButton("Purchase History");
            JButton PostHistory = new JButton("Post History");
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setBounds(600, 300, 420,400);

            JPanel userCenterPanel = new JPanel();
            userCenterPanel.setLayout(new BoxLayout(userCenterPanel, BoxLayout.Y_AXIS));

            JPanel buttons = new JPanel();
            buttons.add(Edit);
            buttons.add(Wallet);
            buttons.add(PurchaseHistory);
            buttons.add(PostHistory);



            ProfileGateway profile;
            try {
                  profile = new FileProfile("./profile.csv");
            } catch (IOException e) {
                  throw new RuntimeException("Could not create profile.csv.");
            }


            String name = profile.getUsername(username);
            String age = profile.getAge(username);
            String gender = profile.getGender(username);
            String description = profile.getDescription(username);
            String address = profile.getAddress(username);
            String phone = profile.getPhone(username);

            System.out.println(name);


            Edit.addActionListener(this);
            Wallet.addActionListener(this);
            PurchaseHistory.addActionListener(this);
            PostHistory.addActionListener(this);

            JPanel panel1 = new JPanel();
            JTextArea profileArea = new JTextArea("Username: " + name + '\n'+ "Age: " + age
                    + '\n' + "gender:" +gender+ '\n' + "self-description:"+description + '\n' + "address:" + address
                    + '\n' + "phone-number:"+ phone + '\n');
            profileArea.setFocusable(false);
            panel1.add(profileArea);

            userCenterPanel.add(panel1);
            userCenterPanel.add(buttons);

            this.add(userCenterPanel);
            this.pack();
            this.setVisible(true);

      }

      @Override
      public void actionPerformed(ActionEvent evt) {
           if (evt.getActionCommand().equals("Edit/Create")){
                  EditPage editPage = new EditPage(username);
                  this.dispose();
            }
            if (evt.getActionCommand().equals("Wallet")){
                  UserDsGateway user;
                  try {
                        user = new FileUser("./users.csv");
                  } catch (IOException e) {
                        throw new RuntimeException("Could not create file.");
                  }
                  double balance = user.getBalance(username);
                  BalancePage balancePage = new BalancePage(balance);
                  balancePage.setVisible(true);
                  //balancePage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
            if (evt.getActionCommand().equals("Purchase History")){
                  OrderDsGateway order;
                  try {
                        order = new FileOrder("./orders.csv");
                  } catch (IOException e) {
                        throw new RuntimeException("Could not create file.");
                  }

                  //PurchaseHistory purchaseHistory = new PurchaseHistory();

            }
            //if (e.getSource() == PostHistory){
            //      PostHistoryPage postpage = new PostHistoryPage();
            //}
      }


}


