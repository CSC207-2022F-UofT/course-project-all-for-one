package presenter;

import javax.swing.*;

public class WalletResponsePresenter{

    public void createBalancePage (double balance){
        JFrame jf = new JFrame("Balance Page");
        jf.setBounds(400, 300, 400, 300);
        JLabel money = new JLabel("Balance:" + balance, SwingConstants.CENTER);
        jf.add(money);


        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
