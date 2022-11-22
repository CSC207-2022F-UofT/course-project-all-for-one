package gateway;

import use_case.MessageDsRequestModel;

public interface MessageDsGateway {

    MessageBoard getBoard(String boardName);

    void save(MessageDsRequestModel requestModel);

//    void delete(String message);






}
