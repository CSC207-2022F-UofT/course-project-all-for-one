package UI;

import controller.MessageController;
import gateway.MessageDsGateway;
import presenter.MessagePresenter;
import presenter.MessageResponseFormatter;
import use_case.MessageInteractor;
import use_case.MessageRequestModel;
import use_case.MessageResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Board extends JFrame {

    JList<String> messageList = new JList<>();
    DefaultListModel<String> model = new DefaultListModel<>();

    JPanel mainPanel = new JPanel();

    JTextArea inputArea = new JTextArea(5, 10);
    JButton postButton = new JButton("Post");


    MessageController controller;


    MessageDsGateway dsGateway;

    MessageResponseModel responseModel;



    public Board(MessageDsGateway dsGateway) {
//        this.controller = controller;
//        this.presenter = presenter;
        this.dsGateway = dsGateway;
        this.responseModel = new MessageResponseModel(dsGateway.getBoard("message"));

        JPanel boardPanel = new JPanel();

        JPanel enterPanel = new JPanel();


        messageList.setModel(model);
        MessagePresenter presenter = new MessageResponseFormatter();
        List<String> lst = presenter.displayBoard(responseModel).getMessageList();
        if (!lst.isEmpty()) {model.addAll(lst);


        mainPanel.setLayout(new BorderLayout());

        boardPanel.setLayout(new BorderLayout());
        boardPanel.add(new JScrollPane(messageList));

        enterPanel.setLayout(new BorderLayout());
        enterPanel.add(inputArea, BorderLayout.WEST);
        enterPanel.add(postButton, BorderLayout.EAST);

        mainPanel.add(boardPanel, BorderLayout.NORTH);
        mainPanel.add(enterPanel, BorderLayout.SOUTH);}

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
                MessageRequestModel requestModel = new MessageRequestModel(input);
                MessagePresenter presenter = new MessageResponseFormatter();
                MessageInteractor interactor = new MessageInteractor(dsGateway, presenter);
                controller = new MessageController(interactor);
                controller.create(input);
                model.addElement(input);
            }
        });

        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();



        }



}


