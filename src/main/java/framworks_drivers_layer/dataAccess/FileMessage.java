package framworks_drivers_layer.dataAccess;

import application_business_rules_layer.messageUseCases.MessageDsGateway;
import enterprise_business_rules_layer.messageEntities.Message;
import enterprise_business_rules_layer.messageEntities.MessageBoard;
import application_business_rules_layer.messageUseCases.MessageDsRequestModel;

import java.io.*;
import java.util.List;

public class FileMessage implements MessageDsGateway {

    private final File csvFile;

    public FileMessage(String csvPath) {
        csvFile = new File(csvPath);
    }



    @Override
    public MessageBoard getBoard(String boardName) {
        MessageBoard board = new MessageBoard(boardName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
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

    /**
     * Add requestModel to storage.
     * @param requestModel the user information to save.
     */
    @Override
    public void save(MessageDsRequestModel requestModel) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
            for (List<Message> board: requestModel.getBoard()){
                for( Message message: board) {
                writer.write(message.getContent() + "\n");}
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//
//    @Override
//    public void delete(String message) {
//
//    }
}
