package Interface_adapters_layer.presenter;

import application_business_rules_layer.messageUseCases.MessageResponseModel;

public interface MessagePresenter {
    MessageResponseModel displayBoard(MessageResponseModel board);
}
