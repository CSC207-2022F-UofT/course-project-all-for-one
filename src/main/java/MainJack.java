import UI.Board;
import gateway.MessageDataManagement;
import gateway.MessageDsGateway;

import javax.swing.*;
import java.io.FileNotFoundException;


public class MainJack {
    public static void main(String[] args) throws FileNotFoundException {


        MessageDsGateway Messages = new MessageDataManagement("./MessageBoard.csv");
        JFrame board = new Board(Messages);
        board.setVisible(true);

    }
}
