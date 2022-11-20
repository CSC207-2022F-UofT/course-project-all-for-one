package UI;

import Controller.MessageController;
import UI.DeleteWindow;
import entities.Message;
import entities.MessageBoard;
import presenter.MessagePresenter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        JFrame demo = new DeleteWindow();
        demo.setVisible(true);
    }

}
