package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.Message;
import enterprise_business_rules_layer.messageEntities.MessageBoard;

public class MessageInteractor implements MessageInputBoundary {

    final MessageDsGateway messageGateway;
    final MessageOutputBoundary messageOutputBoundary;

    /**
     *
     * @param messageDsGateway relay to Interface_adapters.presenter
     * @param messageOutputBoundary Interface_adapters.gateway to reach message file
     */
    public MessageInteractor(MessageDsGateway messageDsGateway, MessageOutputBoundary messageOutputBoundary) {
        this.messageGateway = messageDsGateway;
        this.messageOutputBoundary = messageOutputBoundary;
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

        return messageOutputBoundary.displayBoard(responseModel);

    }
}
