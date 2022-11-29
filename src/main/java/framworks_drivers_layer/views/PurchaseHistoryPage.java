package framworks_drivers_layer.views;

import enterprise_business_rules_layer.orderEntities.PhysicalOrder;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PurchaseHistoryPage {
    public static void PurchaseHistoryPage(String[] args, List<PhysicalOrder> physicalOrders){
        JFrame jf = new JFrame("Purchase History");
        jf.setLayout(new FlowLayout(FlowLayout.CENTER));
        jf.setBounds(400, 300, 300, 200);
        JMenuBar bar = new JMenuBar();
        for (PhysicalOrder physicalOrder : physicalOrders) {
           JMenu menu = new JMenu(physicalOrder.getCreationTime());
           JMenuItem item1 = new JMenuItem("Product: " + physicalOrder.getPost().getTitle());
           JMenuItem item2 = new JMenuItem("Price: $" + physicalOrder.getPost().getPrice());
           JMenuItem item3 = new JMenuItem("Name: " + physicalOrder.getName());
           JMenuItem item4 = new JMenuItem("Address: " + physicalOrder.getAddress());
           JMenuItem item5 = new JMenuItem("Phone Number: " + physicalOrder.getPhoneNumber());
           JMenuItem item6 = new JMenuItem("Status: " + physicalOrder.getShipmentStatus());
           menu.add(item1);
           menu.add(item2);
           menu.add(item3);
           menu.add(item4);
           menu.add(item5);
           menu.add(item6);
           bar.add(menu);
           jf.add(bar);
        }

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
