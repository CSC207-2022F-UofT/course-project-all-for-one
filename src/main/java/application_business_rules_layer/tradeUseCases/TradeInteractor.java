package application_business_rules_layer.tradeUseCases;

import enterprise_business_rules_layer.orderEntities.OrderFactory;
import enterprise_business_rules_layer.orderEntities.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TradeInteractor implements TradeInputBoundry {

    final OrderDsGateway orderDsGateway;
    final TradeOutputBoundry tradeOutputBoundry;
    final OrderFactory orderFactory;




    public TradeInteractor(OrderDsGateway orderDsGateway, TradeOutputBoundry tradeOutputBoundry1, OrderFactory orderFactory1) {
        this.orderDsGateway = orderDsGateway;
        this.tradeOutputBoundry = tradeOutputBoundry1;
        this.orderFactory = orderFactory1;
    }

    @Override
    public TradeResponseModel create(TradeRequestModel requestModel) {
        if (requestModel.getBuyer().getWallet().getBalance() < requestModel.getPost().getPrice()) {
            return tradeOutputBoundry.prepareFailView("Insufficient balance.");
        }

        if (Objects.equals(requestModel.getPost().getStatus(), "Sold")) {
            return tradeOutputBoundry.prepareFailView("Item already sold.");
        }

        requestModel.getBuyer().getWallet().subtractBalance(requestModel.getPost().getPrice());

        requestModel.getSeller().getWallet().addBalance(requestModel.getPost().getPrice());

        LocalDateTime now = LocalDateTime.now();
        String creationTime = now.format(DateTimeFormatter.ofPattern("hh:mm:ss"));

        Order order = orderFactory.create(requestModel.getPost(), creationTime, requestModel.getName(),
                requestModel.getAddress(), requestModel.getPhoneNumber(), "Shipped",
                requestModel.getBuyerUsername(), requestModel.getSellerUsername());

        OrderDsRequestModel orderDsModel = new OrderDsRequestModel(order.getPost().getTitle(), creationTime,
                order.getPost().getPrice(), order.getName(), order.getAddress(), order.getPhoneNumber(),
                order.getShipmentStatus(), order.getBuyerUsername(), order.getSellerUsername());

        requestModel.getPost().setSold();

        orderDsGateway.save(orderDsModel);

        TradeResponseModel tradeResponseModel = new TradeResponseModel("Order Confirmed", creationTime);
        return tradeOutputBoundry.prepareSuccessView(tradeResponseModel);

    }
}
