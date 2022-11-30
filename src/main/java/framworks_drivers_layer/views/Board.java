package framworks_drivers_layer.views;

import Interface_adapters_layer.controller.MessageController;
import application_business_rules_layer.messageUseCases.*;
import Interface_adapters_layer.presenter.MessagePresenter;
import Interface_adapters_layer.presenter.MessageResponseFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Board extends JFrame {

    String username;
    String boardName;

    JList<String> messageList = new JList<>();
    DefaultListModel<String> model = new DefaultListModel<>();
    JPanel mainPanel = new JPanel();
    JTextArea inputArea = new JTextArea(5, 10);
    JButton postButton = new JButton("Post");

    MessageController controller;
    MessageDsGateway dsGateway;
    MessageResponseModel responseModel;



    public Board(MessageDsGateway dsGateway, String boardName) {
        this.boardName = boardName;
        this.dsGateway = dsGateway;
        this.responseModel = new MessageResponseModel(dsGateway.getBoard(boardName));
        JPanel boardPanel = new JPanel();
        JPanel enterPanel = new JPanel();
        messageList.setModel(model);
        MessagePresenter presenter = new MessageResponseFormatter();
        List<String> lst = presenter.displayBoard(responseModel).getMessageList();
        if (!lst.isEmpty()) {
            model.addAll(lst);}
            mainPanel.setLayout(new BorderLayout());

            boardPanel.setLayout(new BorderLayout());
            boardPanel.add(new JScrollPane(messageList));

            enterPanel.setLayout(new BorderLayout());
            enterPanel.add(inputArea, BorderLayout.WEST);
            enterPanel.add(postButton, BorderLayout.EAST);

            mainPanel.add(boardPanel, BorderLayout.NORTH);
            mainPanel.add(enterPanel, BorderLayout.SOUTH);


//        messageList.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                String s = messageList.getSelectedValue();
//                JFrame deleteWindow = new DeleteWindow(s);
//                deleteWindow.setVisible(true);
//            }
//        });

            postButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = inputArea.getText();
                    MessagePresenter presenter = new MessageResponseFormatter();
                    MessageInputBoundary inputBoundary = new MessageInteractor(dsGateway, presenter);
                    controller = new MessageController(inputBoundary);
                    controller.create(input, username, boardName);
                    model.addElement(username + ": " + input);
                    inputArea.setText("");
                }
            });

            this.add(mainPanel);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.pack();
        }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
}











