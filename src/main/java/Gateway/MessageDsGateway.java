package Gateway;

import entities.MessageBoard;
import use_cases.MessageDsRequestModel;

import java.io.IOException;

public interface MessageDsGateway {

    MessageBoard getBoard(String boardName);

    void save(MessageDsRequestModel requestModel);

//    void delete(String message);






}
