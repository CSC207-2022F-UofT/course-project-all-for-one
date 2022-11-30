package application_business_rules_layer.messageUseCases;

import enterprise_business_rules_layer.messageEntities.Message;
import enterprise_business_rules_layer.messageEntities.MessageBoard;
import Interface_adapters_layer.presenter.MessagePresenter;

public class MessageInteractor implements MessageInputBoundary {

    final MessageDsGateway messageGateway;
    final MessagePresenter messagePresenter;

    private Message message;

    private MessageBoard messageBoard;




    public MessageInteractor(MessageDsGateway messageDsGateway, MessagePresenter messagePresenter) {
        this.messageGateway = messageDsGateway;
        this.messagePresenter = messagePresenter;
    }

    @Override
    public MessageResponseModel create(MessageRequestModel requestModel) {
//        if (requestModel.getDelete() != null) {
//            messageGateway.delete(requestModel.getDelete().getContent()); //if input a delete message, delete it
//        }

        Message add = requestModel.getMessage();
        MessageBoard board = messageGateway.getBoard("iphone");
        board.addMessage(add);  //add new message to the board
        messageGateway.save(new MessageDsRequestModel(board, add));  // write the new MessageBoard to file}

        MessageResponseModel responseModel = new MessageResponseModel(board);

        return messagePresenter.displayBoard(responseModel);


    }
}



//    private Message message;
//    private MessageBoard messageBoard;
//
//
//
//    public MessageInteractor(MessageOutputBoundary messageOutputBoundary) {
//        this.messageOutputBoundary = messageOutputBoundary;
//
//    }
//
//    @Override
//    public void inputMessage(String content, MessageBoard board) {
//        this.message = new Message(content);
//        this.messageBoard = board;
//        AddMessage.addMessage(this.message, this.messageBoard);
//        messageOutputBoundary.displayMessage(this.messageBoard);
//
//    }
//
//    @Override
//    public void deleteMessage(String content, MessageBoard board) {
//        this.message = new Message(content);
//        this.messageBoard = board;
//        DeleteMessage.deleteMessage(this.message, this.messageBoard);
//        messageOutputBoundary.displayMessage(this.messageBoard);
//    }
//}
