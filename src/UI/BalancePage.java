package UI;

import javax.swing.*;

public class BalancePage extends JPanel{
    public BalancePage(double balance) {
        JLabel money = new JLabel("Balance:" + balance, SwingConstants.CENTER);
    }
}
