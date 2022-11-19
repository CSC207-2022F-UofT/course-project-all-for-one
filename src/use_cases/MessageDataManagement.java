package use_cases;

import entities.Message;
import entities.MessageBoard;

import java.io.*;
import java.util.List;

public class MessageDataManagement implements MessageDsGateway{

    private String fileName;

    public MessageDataManagement(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public MessageBoard getBoard(String boardName) {
        MessageBoard board = new MessageBoard(boardName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            Message message;
            while((line = reader.readLine()) != null){
                message = new Message(line);
                board.addMessage(message);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return board;
    }

    @Override
    public void save(MessageDsRequestModel requestModel) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (List<Message> board: requestModel.getBoard()){
                for( Message message: board) {
                writer.write(message.getContent() + "\n");}
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(String message) {

    }
}
