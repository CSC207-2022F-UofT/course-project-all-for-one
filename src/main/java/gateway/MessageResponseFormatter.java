package gateway;

import presenter.MessagePresenter;
import use_case.MessageResponseModel;

public class MessageResponseFormatter implements MessagePresenter {
    @Override
    public MessageResponseModel displayBoard(MessageResponseModel response) {


        return response;
    }
}
