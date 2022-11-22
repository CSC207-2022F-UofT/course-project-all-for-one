package UI;

import entities.Order;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PurchaseHistoryPage {
    public static void PurchaseHistoryPage(String[] args, List<Order> orders){
        JFrame jf = new JFrame("Purchase History");
        jf.setLayout(new FlowLayout(FlowLayout.CENTER));
        jf.setBounds(400, 300, 300, 200);
        JMenuBar bar = new JMenuBar();
        for (Order order : orders) {
           JMenu menu = new JMenu(order.getCreationTime());
           JMenuItem item1 = new JMenuItem("Product: " + order.getPost().getTitle());
           JMenuItem item2 = new JMenuItem("Price: $" + order.getPost().getPrice());
           JMenuItem item3 = new JMenuItem("Name: " + order.getName());
           JMenuItem item4 = new JMenuItem("Address: " + order.getAddress());
           JMenuItem item5 = new JMenuItem("Phone Number: " + order.getPhoneNumber());
           JMenuItem item6 = new JMenuItem("Status: " + order.getShipmentStatus());
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
