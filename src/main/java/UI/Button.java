package UI;

import javax.swing.*;

public class Button {
    static JButton Edit = new JButton("Edit/Create");
    static JButton Wallet = new JButton("Wallet");
    static JButton PurchaseHistory = new JButton("Purchase History");
    static JButton PostHistory = new JButton("Post History");
    static JButton MessageBoard = new JButton("Message Board");
    static JButton BrowsingHistory = new JButton("Browsing History");

    public static JButton getEdit(){return Edit;}
    public static JButton getWallet(){return Wallet;}
    public static JButton getPurchaseHistory(){return PurchaseHistory;}
    public static JButton getPostHistory() {return PostHistory;}
    public static JButton getMessageBoard(){return MessageBoard;}
    public static JButton getBrowsingHistory(){return BrowsingHistory;}
}
