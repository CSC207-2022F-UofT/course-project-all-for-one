package application_business_rules_layer.tradeUseCases;

import application_business_rules_layer.userUseCases.UserDsGateway;
import application_business_rules_layer.userUseCases.UserDsRequestModel;
import enterprise_business_rules_layer.orderEntities.OrderFactory;
import enterprise_business_rules_layer.orderEntities.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TradeInteractor implements TradeInputBoundry {

    final OrderDsGateway orderDsGateway;
    final UserDsGateway userDsGateway;
    final TradeOutputBoundry tradeOutputBoundry;
    final OrderFactory orderFactory;




    public TradeInteractor(OrderDsGateway orderDsGateway, UserDsGateway userDsGateway1,
                           TradeOutputBoundry tradeOutputBoundry1, OrderFactory orderFactory1) {
        this.orderDsGateway = orderDsGateway;
        this.userDsGateway = userDsGateway1;
        this.tradeOutputBoundry = tradeOutputBoundry1;
        this.orderFactory = orderFactory1;
    }

    @Override
    public TradeResponseModel create(TradeRequestModel requestModel) {
        if (userDsGateway.getBalance(requestModel.getBuyerUsername()) < requestModel.getPost().getPrice()) {
            return tradeOutputBoundry.prepareFailView("Insufficient balance.");
        }

        if (Objects.equals(requestModel.getPost().getStatus(), "Sold")) {
            return tradeOutputBoundry.prepareFailView("Item already sold.");
        }

        double buyerOldBalance = userDsGateway.getBalance(requestModel.getBuyerUsername());
        double sellerOldBalance = userDsGateway.getBalance(requestModel.getSellerUsername());
        double buyerNewBalance = buyerOldBalance - requestModel.getPost().getPrice();
        double sellerNewBalance = sellerOldBalance + requestModel.getPost().getPrice();

        userDsGateway.changeBalance(requestModel.getBuyerUsername(), buyerNewBalance);
        userDsGateway.changeBalance(requestModel.getSellerUsername(), sellerNewBalance);


//        requestModel.getBuyer().getWallet().subtractBalance(requestModel.getPost().getPrice());
//        requestModel.getSeller().getWallet().addBalance(requestModel.getPost().getPrice());

        LocalDateTime now = LocalDateTime.now();
        String creationTime = now.format(DateTimeFormatter.ofPattern("hh:mm:ss"));

        Order order = orderFactory.create(requestModel.getPost(), creationTime, requestModel.getName(),
                requestModel.getAddress(), requestModel.getPhoneNumber(), "Shipped",
                requestModel.getBuyerUsername(), requestModel.getSellerUsername());

        OrderDsRequestModel orderDsModel = new OrderDsRequestModel(order.getPost().getTitle(), creationTime,
                order.getPost().getPrice(), order.getName(), order.getAddress(), order.getPhoneNumber(),
                order.getShipmentStatus(), order.getBuyerUsername(), order.getSellerUsername(),
                order.getPost().getTags());

        requestModel.getPost().setSold();

        orderDsGateway.save(orderDsModel);

        TradeResponseModel tradeResponseModel = new TradeResponseModel("Order Confirmed", creationTime);
        return tradeOutputBoundry.prepareSuccessView(tradeResponseModel);

    }
}
