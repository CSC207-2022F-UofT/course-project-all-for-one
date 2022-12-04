package framworks_drivers_layer.views;

import javax.swing.*;

public class BalancePage extends JFrame{
    public BalancePage(double balance) {
        JLabel money = new JLabel("Balance: $" + balance, SwingConstants.CENTER);
        this.add(money);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(400, 300,400,300);
        this.pack();
    }
}
