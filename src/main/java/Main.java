import UI.Board;
import Gateway.MessageDataManagement;
import Gateway.MessageDsGateway;
import entities.Message;
import entities.MessageBoard;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        File csvFile = new File("/Users/jackjin/Desktop/UofT/CSC207/course-project-all-for-one/src/main/java/MessageBoard.csv");

        MessageDsGateway Messages = new MessageDataManagement("/Users/jackjin/Desktop/UofT/CSC207/course-project-all-for-one/src/main/java/MessageBoard.csv");
        JFrame board = new Board(Messages);
        board.setVisible(true);

//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
//            String line;
//
//            while((line = reader.readLine()) != null){
//
//                lst.add(line);
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(lst);





    }
}
