package Interface_adapters_layer.gateway;

import Interface_adapters_layer.presenter.MessagePresenter;
import application_business_rules_layer.messageUseCases.MessageResponseModel;

public class MessageResponseFormatter implements MessagePresenter {
    @Override
    public MessageResponseModel displayBoard(MessageResponseModel response) {


        return response;
    }
}
