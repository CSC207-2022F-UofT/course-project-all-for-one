package framworks_drivers_layer.views;

import Interface_adapters_layer.controller.MessageController;
import Interface_adapters_layer.presenter.BuyPresenter;
import application_business_rules_layer.messageUseCases.MessageOutputBoundary;
import Interface_adapters_layer.presenter.MessageResponseFormatter;
import application_business_rules_layer.messageUseCases.MessageDsGateway;
import application_business_rules_layer.messageUseCases.MessageInteractor;
import application_business_rules_layer.messageUseCases.MessageRequestModel;
import application_business_rules_layer.messageUseCases.MessageResponseModel;
import application_business_rules_layer.postUseCases.PostDsGateway;
import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import application_business_rules_layer.userUseCases.UserDsGateway;
import enterprise_business_rules_layer.postEntities.Post;
import framworks_drivers_layer.dataAccess.FileOrder;
import framworks_drivers_layer.dataAccess.FilePost;
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

        messageList.setModel(model);
        MessageOutputBoundary presenter = new MessageResponseFormatter();
        List<String> lst = presenter.displayBoard(responseModel).getMessageList();

        JLabel dPostTitle = new JLabel("Title: " + Post.getTitle());
        JLabel dPostDescription = new JLabel("Description: " + Post.getDescription());
        JLabel dPrice = new JLabel("Price: " + Post.getPrice());
        JLabel dSeller = new JLabel("Seller: " + post.getUsername());

        JButton postButton = new JButton("Post");

        postInfoPanel.setLayout(new BoxLayout(postInfoPanel, BoxLayout.Y_AXIS));
        postInfoPanel.add(dPostTitle);
        postInfoPanel.add(dPostDescription);
        postInfoPanel.add(dPrice);
        postInfoPanel.add(dSeller);

        postPanel.setLayout(new BorderLayout());
        postPanel.add(postInfoPanel, BorderLayout.WEST);

        if (!Post.getUsername().equals(buyerUsername)){
            JButton buyButton = new JButton("Buy");
            postPanel.add(buyButton, BorderLayout.EAST);
            buyButton.addActionListener(this);
        }
        else{
            JButton deleteButton = new JButton("Delete");
            postPanel.add(deleteButton, BorderLayout.EAST);
            deleteButton.addActionListener(this);
        }

        JFrame board = new Board(dsGateway, Post.getTitle(), buyerUsername);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(postPanel);

        board.setVisible(true);


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
                throw new RuntimeException("Could not create users.csv.");
            }
            BuyPresenter.creatConfirmPage(Post, buyerUsername, order, user);

        }
        else if (evt.getActionCommand().equals("Delete")) {
            this.dispose();
            PostDsGateway post;
            try {
                post = new FilePost("./posts.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create posts.csv.");
            }
            post.delete(this.Post.getId());
        }
        else{
            String input = inputArea.getText();
            MessageRequestModel requestModel = new MessageRequestModel(input, buyerUsername, Post.getTitle());
            MessageOutputBoundary presenter = new MessageResponseFormatter();
            MessageInteractor interactor = new MessageInteractor(dsGateway, presenter);
            controller = new MessageController(interactor);
            controller.create(input, buyerUsername, Post.getTitle());
            model.addElement(input);
            inputArea.setText("");
        }

    }



}
