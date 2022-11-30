package framworks_drivers_layer.dataAccess;

import application_business_rules_layer.messageUseCases.MessageDsGateway;
import enterprise_business_rules_layer.messageEntities.Message;
import enterprise_business_rules_layer.messageEntities.MessageBoard;
import application_business_rules_layer.messageUseCases.MessageDsRequestModel;

import java.io.*;
import java.util.Objects;

public class FileMessage implements MessageDsGateway {

    private final File csvFile;
    private final String csvPath;

    public FileMessage(String csvPath) {
        csvFile = new File(csvPath);
        this.csvPath = csvPath;
    }


    /**
     *
     * @param boardName the name of the message board
     * @return the message board of the given board name
     */
    @Override
    public MessageBoard getBoard(String boardName) {
        MessageBoard board = new MessageBoard(boardName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));

            String line;
            Message message;

            while((line = reader.readLine()) != null){
                String[] lst = line.split(",");
                if (Objects.equals(lst[0], boardName)) {
                    message = new Message(lst[2],lst[1]);
                    board.addMessage(message);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return board;
    }

    /**
     * Add requestModel to storage.
     * @param requestModel the message information to save.
     */
    @Override
    public void save(MessageDsRequestModel requestModel) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvPath, true));
            String line = requestModel.getBoard().getName() + "," + requestModel.getMessage().getUsername() + ","
                    + requestModel.getMessage().getContent() + "\n";
            writer.write(line);


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
