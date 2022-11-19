package use_cases;

import entities.Message;
import entities.MessageBoard;
import presenter.MessagePresenter;

public class MessageInteractor implements MessageInputBoundary {

    final MessageDsGateway messageGateway;
    final MessageBoardPresenter messagePresenter;

    private Message message;

    private MessageBoard messageBoard;




    public MessageInteractor(MessageDsGateway messageDsGateway, MessageBoardPresenter messagePresenter) {
        this.messageGateway = messageDsGateway;
        this.messagePresenter = messagePresenter;
    }

    @Override
    public MessageResponseModel create(MessageRequestModel requestModel) {
        if (requestModel.getDelete() != null) {
            messageGateway.delete(requestModel.getDelete().getContent()); //if input a delete message, delete it
        }
        Message add = requestModel.getMessage();
        MessageBoard board = requestModel.getBoard();
        board.addMessage(add);  //add new message to the board
        messageGateway.save(new MessageDsRequestModel(board));  // write the new MessageBoard to file

        return messagePresenter.displayBoard();

        MessageDsRequestModel messageDsModel = new MessageDsRequestModel(messageBoard);
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
