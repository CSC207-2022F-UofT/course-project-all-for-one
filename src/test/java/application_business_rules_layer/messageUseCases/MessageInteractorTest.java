package application_business_rules_layer.messageUseCases;

import Interface_adapters_layer.presenter.MessagePresenter;
import Interface_adapters_layer.presenter.MessageResponseFormatter;
import enterprise_business_rules_layer.messageEntities.MessageBoard;
import framworks_drivers_layer.dataAccess.FileMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class MessageInteractorTest {
    static int n=3;

   MessageRequestModel requestModel = new MessageRequestModel("I like this", "Jack", "iphone");
   MessageDsGateway dsGateway = new FileMessage("./MessageTest.csv");
   MessagePresenter presenter = new MessageResponseFormatter();
   MessageInteractor interactor = new MessageInteractor(dsGateway, presenter);



    @Test
    public void create() {
        MessageResponseModel responseModel = interactor.create(requestModel);
        assertEquals(responseModel.getMessageList().size(), n);
        n += 1;

    }

}
