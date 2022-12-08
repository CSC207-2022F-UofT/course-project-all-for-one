package application_business_rules_layer.messageUseCases;
import Interface_adapters_layer.presenter.MessageResponseFormatter;
import framworks_drivers_layer.dataAccess.FileMessage;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MessageInteractorTest {
    static int n=3;

   MessageRequestModel requestModel = new MessageRequestModel("I like this", "Jack", "iphone");
   MessageDsGateway dsGateway = new FileMessage("./MessageTest.csv");
   MessageOutputBoundary presenter = new MessageResponseFormatter();
   MessageInteractor interactor = new MessageInteractor(dsGateway, presenter);



    @Test
    public void create() {
        MessageResponseModel responseModel = interactor.create(requestModel);
        int l = responseModel.getMessageList().size()-1;
        assertEquals(responseModel.getMessageList().get(l), "Jack: I like this");

    }

}
