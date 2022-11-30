import framworks_drivers_layer.views.Board;
import framworks_drivers_layer.dataAccess.FileMessage;
import application_business_rules_layer.messageUseCases.MessageDsGateway;

import javax.swing.*;
import java.io.FileNotFoundException;


public class MainJack {
    public static void main(String[] args) throws FileNotFoundException {


        MessageDsGateway Messages = new FileMessage("./MessageBoard.csv");
        JFrame board = new Board(Messages, "iphone");
        board.setVisible(true);

    }
}
