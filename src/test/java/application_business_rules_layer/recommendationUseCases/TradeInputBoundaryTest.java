package application_business_rules_layer.recommendationUseCases;

import Interface_adapters_layer.presenter.TradePresenter;
import application_business_rules_layer.postUseCases.PostDsGateway;
import application_business_rules_layer.postUseCases.PostDsRequestModel;
import application_business_rules_layer.tradeUseCases.*;
import application_business_rules_layer.userUseCases.UserDsGateway;
import application_business_rules_layer.userUseCases.UserDsRequestModel;
import enterprise_business_rules_layer.orderEntities.OrderFactory;
import enterprise_business_rules_layer.orderEntities.PhysicalOrderFactory;
import enterprise_business_rules_layer.postEntities.Post;
import framworks_drivers_layer.dataAccess.MemoryOrder;
import framworks_drivers_layer.dataAccess.MemoryPost;
import framworks_drivers_layer.dataAccess.MemoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

class TradeInputBoundryTest {

    @Test
    void orderSuccessTest1() {

        ArrayList<String> tagsOftestPost1 = new ArrayList<>();
        tagsOftestPost1.add("iphone");
        tagsOftestPost1.add("apple");
        LocalDateTime testTime = LocalDateTime.now();
        Post testPost1 = new Post("xavier", "iPhone 14", "Like new", 500, tagsOftestPost1);
        PostDsRequestModel postDsRequestModel = new PostDsRequestModel(testPost1.getUsername(), testPost1.getTitle(),
                testPost1.getDescription(), testPost1.getPrice(), testPost1.getTags(), testTime, testPost1.getId());


        TradeRequestModel requestModel = new TradeRequestModel(testPost1, testTime, "Steve",
                "40 Willcocks", "5149996666", "steve");

        OrderDsGateway orderDsGateway = new MemoryOrder();

        UserDsGateway userDsGateway = new MemoryUser();
        UserDsRequestModel userDsRequestModel1 = new UserDsRequestModel("steve", "123456", testTime, 1000);
        UserDsRequestModel userDsRequestModel2 = new UserDsRequestModel("xavier", "654321", testTime, 1000);
        userDsGateway.save(userDsRequestModel1);
        userDsGateway.save(userDsRequestModel2);

        TradeOutputBoundry tradeOutputBoundry = new TradePresenter();
        OrderFactory orderFactory = new PhysicalOrderFactory();

        PostDsGateway postDsGateway = new MemoryPost();
        postDsGateway.save(postDsRequestModel);


        TradeInputBoundary tradeInputBoundary = new TradeInteractor(orderDsGateway, userDsGateway, tradeOutputBoundry,
                orderFactory, postDsGateway);
        tradeInputBoundary.create(requestModel);

        Assertions.assertEquals(0, postDsGateway.getMap().size());
        Assertions.assertEquals(1, orderDsGateway.getPurchaseHistory("steve").size());
        Assertions.assertEquals(500, userDsGateway.getBalance("steve"));
        Assertions.assertEquals(1500, userDsGateway.getBalance("xavier"));
    }

    @Test
    void orderFailTest1() {

        ArrayList<String> tagsOftestPost2 = new ArrayList<>();
        tagsOftestPost2.add("iphone");
        tagsOftestPost2.add("apple");
        LocalDateTime testTime = LocalDateTime.now();
        Post testPost2 = new Post("xavier", "iPhone 14", "Like new", 1500, tagsOftestPost2);
        PostDsRequestModel postDsRequestModel = new PostDsRequestModel(testPost2.getUsername(), testPost2.getTitle(),
                testPost2.getDescription(), testPost2.getPrice(), testPost2.getTags(), testTime, testPost2.getId());


        TradeRequestModel requestModel = new TradeRequestModel(testPost2, testTime, "Steve",
                "40 Willcocks", "5149996666", "steve");

        OrderDsGateway orderDsGateway = new MemoryOrder();

        UserDsGateway userDsGateway = new MemoryUser();
        UserDsRequestModel userDsRequestModel1 = new UserDsRequestModel("steve", "123456", testTime, 1000);
        UserDsRequestModel userDsRequestModel2 = new UserDsRequestModel("xavier", "654321", testTime, 1000);
        userDsGateway.save(userDsRequestModel1);
        userDsGateway.save(userDsRequestModel2);

        TradeOutputBoundry tradeOutputBoundry = new TradePresenter() {
            @Override
            public TradeResponseModel prepareSuccessView(TradeResponseModel responseModel) {

                return responseModel;
            }

            @Override
            public TradeResponseModel prepareFailView(String error) {
                Assertions.assertEquals(error, "Insufficient balance.");
                return null;
            }
        };

        OrderFactory orderFactory = new PhysicalOrderFactory();

        PostDsGateway postDsGateway = new MemoryPost();
        postDsGateway.save(postDsRequestModel);


        TradeInputBoundary tradeInputBoundary = new TradeInteractor(orderDsGateway, userDsGateway, tradeOutputBoundry,
                orderFactory, postDsGateway);
        tradeInputBoundary.create(requestModel);

        Assertions.assertEquals(1, postDsGateway.getMap().size());
        Assertions.assertEquals(0, orderDsGateway.getPurchaseHistory("steve").size());
        Assertions.assertEquals(1000, userDsGateway.getBalance("steve"));
        Assertions.assertEquals(1000, userDsGateway.getBalance("xavier"));
    }
}