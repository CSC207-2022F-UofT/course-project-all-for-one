package framworks_drivers_layer.views;//package framworks_drivers.UI;
//
//import Controller.MessageController;
//import Interface_adapters.presenter.MessagePresenter;
//import Interface_adapters.presenter.MessageResponseFormatter;
//import use_cases.*;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class DeleteWindow extends JFrame {
//
//    String deleteMessage;
//
//    MessagePresenter Interface_adapters.presenter = new MessageResponseFormatter();
//
//    MessageInteractor interactor;
//
//    MessageController Interface_adapters.presenter.controller;
//    JPanel mainPanel = new JPanel();
//    JButton yes = new JButton("Yes");
//    JButton no = new JButton("No");
//    JLabel delete = new JLabel("Are you sure you want to delete this message?");
//
//    public DeleteWindow(String deleteMessage) throws HeadlessException {
//        this.deleteMessage = deleteMessage;
//
//        JPanel deleteMessagePanel = new JPanel();
//        JPanel buttonPanel = new JPanel();
//
//        deleteMessagePanel.add(delete);
//        buttonPanel.add(no);
//        buttonPanel.add(yes);
//
//
//        mainPanel.setLayout(new BorderLayout());
//        mainPanel.add(deleteMessagePanel, BorderLayout.NORTH);
//        mainPanel.add(buttonPanel, BorderLayout.CENTER);
//        this.add(mainPanel);
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        this.pack();
//
//        yes.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Interface_adapters.presenter.controller.create(null, deleteMessage);
//                dispose();
//            }
//        });
//
//        no.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//            }
//        });
//
//    }
//
//}
