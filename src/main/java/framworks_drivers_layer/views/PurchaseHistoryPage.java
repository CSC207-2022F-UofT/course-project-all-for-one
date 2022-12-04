package framworks_drivers_layer.views;

import application_business_rules_layer.tradeUseCases.OrderDsRequestModel;

import javax.swing.*;

import java.util.List;

public class PurchaseHistoryPage extends JFrame {

    public PurchaseHistoryPage(String username, List<OrderDsRequestModel> orders) {

        JFrame purchaseHistoryFrame = new JFrame("Purchase History Page");
        purchaseHistoryFrame.setBounds(400, 300, 400, 300);

        JPanel history = new JPanel();
        history.setLayout(new BoxLayout(history, BoxLayout.Y_AXIS));
        for(int j = 0; j < orders.size(); j++){
            JPanel jp1 = new JPanel();
            jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
            if (orders.get(j).getBuyerUsername().equals(username)){
                jp1.add(new JLabel("Item" + (j + 1) + "(As Buyer)"));
                jp1.add(new JLabel("Title: " + orders.get(j).getTitle()));
                jp1.add(new JLabel("Seller: " + orders.get(j).getSellerUsername()));
            } else {
                jp1.add(new JLabel("Item" + (j + 1) + "(As Seller)"));
                jp1.add(new JLabel("Title: " + orders.get(j).getTitle()));
                jp1.add(new JLabel("Buyer: " + orders.get(j).getBuyerUsername()));
            }
            jp1.add(new JLabel("Price: " + orders.get(j).getPrice()));
            jp1.add(new JLabel(" "));
            history.add(jp1);

        }
        JScrollPane historyScrollPanel = new JScrollPane(history, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        historyScrollPanel.setViewportView(history);
        purchaseHistoryFrame.add(historyScrollPanel);
        purchaseHistoryFrame.setVisible(true);
        purchaseHistoryFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }


}

