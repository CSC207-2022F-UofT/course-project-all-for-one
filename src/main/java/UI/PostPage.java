package UI;

import controller.TradeController;
import entity.Account;
import entity.OrderFactory;
import entity.Post;
import presenter.BuyPresenter;
import presenter.TradePresenter;
import use_case.TradeInputBoundry;
import use_case.TradeInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostPage extends JPanel implements ActionListener {

    public Post Post;

    public String CreationTime;

    Account PossibleBuyer;

    public Account Seller;




    public PostPage(Post post, String creationTime, Account possibleBuyer, Account seller) {


        this.Post = post;
        this.CreationTime = creationTime;
        this.PossibleBuyer = possibleBuyer;
        this.Seller = seller;


        JLabel dPostTitle = new JLabel(Post.getTitle());

        JLabel dPostDescription = new JLabel(Post.getDescription());

        JLabel dPrice = new JLabel(Double.toString(Post.get_price()));

        JLabel dCreationTime = new JLabel(CreationTime);

        JLabel dSeller = new JLabel(Seller.getUsername());

        JButton buy = new JButton("Buy");

        JPanel buttons = new JPanel();
        buttons.add(buy);

        buy.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(dPostTitle);
        this.add(dPostDescription);
        this.add(dPrice);
        this.add(dCreationTime);
        this.add(dSeller);
        this.add(buttons);
    }


    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        TradePresenter presenter = new TradePresenter();
        OrderFactory orderFactory = new OrderFactory();
        TradeInputBoundry interactor = new TradeInteractor(presenter, orderFactory);
        TradeController controller = new TradeController(interactor);

        BuyPresenter.creatConfirmPage(Post, CreationTime, PossibleBuyer, Seller, controller);
    }
}
