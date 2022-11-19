package use_cases;

import entities.MessageBoard;

import java.io.IOException;

public interface MessageDsGateway {

    MessageBoard getBoard(String boardName);

    void save(MessageDsRequestModel requestModel);

    void delete(String message);






}
