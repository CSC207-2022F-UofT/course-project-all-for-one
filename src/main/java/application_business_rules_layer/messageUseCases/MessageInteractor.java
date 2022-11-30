package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.Message;
import enterprise_business_rules_layer.messageEntities.MessageBoard;
import Interface_adapters_layer.presenter.MessagePresenter;

public class MessageInteractor implements MessageInputBoundary {

    final MessageDsGateway messageGateway;
    final MessagePresenter messagePresenter;

    /**
     *
     * @param messageDsGateway relay to Interface_adapters.presenter
     * @param messagePresenter Interface_adapters.gateway to reach message file
     */
    public MessageInteractor(MessageDsGateway messageDsGateway, MessagePresenter messagePresenter) {
        this.messageGateway = messageDsGateway;
        this.messagePresenter = messagePresenter;
    }

    /**
     *
     * @param requestModel pack of input data need to be processed
     * @return MessageResponseModel has a formatted list contained all messages of the given MessageBoard
     */
    @Override
    public MessageResponseModel create(MessageRequestModel requestModel) {

        Message add = requestModel.getMessage();
        MessageBoard board = messageGateway.getBoard(requestModel.getBoardName());
        board.addMessage(add);  //add new message to the board
        messageGateway.save(new MessageDsRequestModel(board, add));  // write the new MessageBoard to file}

        MessageResponseModel responseModel = new MessageResponseModel(board);

        return messagePresenter.displayBoard(responseModel);

    }
}
