package framworks_drivers_layer.views;

import Interface_adapters_layer.controller.MessageController;
import Interface_adapters_layer.presenter.BuyPresenter;
import Interface_adapters_layer.presenter.MessagePresenter;
import Interface_adapters_layer.presenter.MessageResponseFormatter;
import application_business_rules_layer.messageUseCases.MessageDsGateway;
import application_business_rules_layer.messageUseCases.MessageInteractor;
import application_business_rules_layer.messageUseCases.MessageRequestModel;
import application_business_rules_layer.messageUseCases.MessageResponseModel;
import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import application_business_rules_layer.userUseCases.UserDsGateway;
import enterprise_business_rules_layer.postEntities.Post;
import framworks_drivers_layer.dataAccess.FileOrder;
import framworks_drivers_layer.dataAccess.FileUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class PostPage extends JFrame implements ActionListener {

    public Post Post;

    String buyerUsername;

    MessageController controller;

    MessageDsGateway dsGateway;

    MessageResponseModel responseModel;

    JTextArea inputArea = new JTextArea(5, 10);

    JList<String> messageList = new JList<>();

    DefaultListModel<String> model = new DefaultListModel<>();




    public PostPage(Post post, String buyerUsername, MessageDsGateway dsGateway) {
        this.setLocation(450, 300);


        this.Post = post;
        this.buyerUsername = buyerUsername;
        this.dsGateway = dsGateway;
        this.responseModel = new MessageResponseModel(dsGateway.getBoard(post.getTitle()));

        JPanel mainPanel = new JPanel();
        JPanel postPanel = new JPanel();
        JPanel postInfoPanel = new JPanel();
        JPanel messagePanel = new JPanel();
        JPanel boardPanel = new JPanel();
        JPanel enterPanel = new JPanel();



        messageList.setModel(model);
        MessagePresenter presenter = new MessageResponseFormatter();
        List<String> lst = presenter.displayBoard(responseModel).getMessageList();

        JLabel dPostTitle = new JLabel("Title: " + Post.getTitle());
        JLabel dPostDescription = new JLabel("Description: " + Post.getDescription());
        JLabel dPrice = new JLabel("Price: " + Double.toString(Post.getPrice()));
        JLabel dSeller = new JLabel("Seller: " + post.getUsername());

        JButton buyButton = new JButton("Buy");
        JButton postButton = new JButton("Post");

        postInfoPanel.setLayout(new BoxLayout(postInfoPanel, BoxLayout.Y_AXIS));
        postInfoPanel.add(dPostTitle);
        postInfoPanel.add(dPostDescription);
        postInfoPanel.add(dPrice);
        postInfoPanel.add(dSeller);

        postPanel.setLayout(new BorderLayout());
        postPanel.add(postInfoPanel, BorderLayout.WEST);
        postPanel.add(buyButton, BorderLayout.EAST);


        if (!lst.isEmpty()) {
            model.addAll(lst);
            messagePanel.setLayout(new BorderLayout());

            boardPanel.setLayout(new BorderLayout());
            boardPanel.add(new JScrollPane(messageList));

            enterPanel.setLayout(new BorderLayout());
            enterPanel.add(inputArea, BorderLayout.WEST);
            enterPanel.add(postButton, BorderLayout.EAST);

            messagePanel.add(boardPanel, BorderLayout.NORTH);
            messagePanel.add(enterPanel, BorderLayout.SOUTH);
        }
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(postPanel);
        mainPanel.add(messagePanel);

        buyButton.addActionListener(this);
        postButton.addActionListener(this);


        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }


    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getActionCommand().equals("Buy")) {
            OrderDsGateway order;
            try {
                order = new FileOrder("./orders.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create file.");
            }

            UserDsGateway user;
            try {
                user = new FileUser("./users.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create file.");
            }

            BuyPresenter.creatConfirmPage(Post, buyerUsername, order, user);
        }
        else{
            String input = inputArea.getText();
            MessageRequestModel requestModel = new MessageRequestModel(input, buyerUsername, Post.getTitle());
            MessagePresenter presenter = new MessageResponseFormatter();
            MessageInteractor interactor = new MessageInteractor(dsGateway, presenter);
            controller = new MessageController(interactor);
            controller.create(input, buyerUsername, Post.getTitle());
            model.addElement(input);
            inputArea.setText("");
        }

    }



}
