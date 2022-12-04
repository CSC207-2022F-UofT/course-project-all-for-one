package framworks_drivers_layer.views;

import application_business_rules_layer.tradeUseCases.OrderDsRequestModel;

import javax.swing.*;

import java.util.List;

public class PurchaseHistoryPage extends JFrame {

    private final List<OrderDsRequestModel> orders;

    public PurchaseHistoryPage(List<OrderDsRequestModel> orders) {
        this.orders = orders;

        JFrame purchaseHistoryFrame = new JFrame("Purchase History Page");
        purchaseHistoryFrame.setBounds(400, 300, 400, 300);

        JPanel history = new JPanel();
        history.setLayout(new BoxLayout(history, BoxLayout.Y_AXIS));
        for(int j = 0; j < orders.size(); j++){
            JPanel jp1 = new JPanel();
            jp1.add(new JLabel(orders.get(j).getTitle()));
            jp1.add(new JLabel(orders.get(j).getSellerUsername()));
            jp1.add(new JLabel(String.valueOf(orders.get(j).getPrice())));
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

