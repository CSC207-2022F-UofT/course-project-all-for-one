package UI;


import Controller.MessageController;
import presenter.MessagePresenter;
import use_cases.MessageInteractor;
import use_cases.MessageResponseModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

public class Board extends JFrame {

    JList<String> messageList = new JList<>();
    DefaultListModel<String> model = new DefaultListModel<>();

    JPanel mainPanel = new JPanel();

    MessageController controller;
    MessagePresenter presenter;

    MessageResponseModel responseModel;


    public Board(MessageController controller, MessagePresenter presenter) {
        this.controller = controller;
        this.presenter = presenter;

        JPanel boardPanel = new JPanel();

        messageList.setModel(model);
        model.addAll(presenter.displayBoard(responseModel).getMessageList());

        mainPanel.setLayout(new BorderLayout());
        boardPanel.setLayout(new BorderLayout());
        boardPanel.add(new JScrollPane(messageList));
        mainPanel.add(boardPanel, BorderLayout.NORTH);

        messageList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String s = messageList.getSelectedValue();
            }
        });

        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();



        }



}


