package application_business_rules_layer.tradeUseCases;

import application_business_rules_layer.userUseCases.UserDsGateway;
import enterprise_business_rules_layer.orderEntities.OrderFactory;
import enterprise_business_rules_layer.orderEntities.Order;

import java.util.Objects;

public class TradeInteractor implements TradeInputBoundary {

    final OrderDsGateway orderDsGateway;
    final UserDsGateway userDsGateway;
    final TradeOutputBoundry tradeOutputBoundry;
    final OrderFactory orderFactory;

    /**
     *
     * @param orderDsGateway Interface_adapters.gateway to reach order database
     * @param userDsGateway Interface_adapters.gateway to reach user database
     * @param tradeOutputBoundary  relay to Interface-adapters.presenter
     * @param orderFactory factory to create Order entity
     */
    public TradeInteractor(OrderDsGateway orderDsGateway, UserDsGateway userDsGateway,
                           TradeOutputBoundry tradeOutputBoundary, OrderFactory orderFactory) {
        this.orderDsGateway = orderDsGateway;
        this.userDsGateway = userDsGateway;
        this.tradeOutputBoundry = tradeOutputBoundary;
        this.orderFactory = orderFactory;
    }

    /**
     *
     * @param requestModel TradeRequestModel that serves as the input needed for processing
     * @return TradeResponseModel object that contains the success message and the creation time of the order
     */
    @Override
    public TradeResponseModel create(TradeRequestModel requestModel) {

        // determine if the buyer has enough balance for the purchase
        if (userDsGateway.getBalance(requestModel.getBuyerUsername()) < requestModel.getPost().getPrice()) {
            return tradeOutputBoundry.prepareFailView("Insufficient balance.");
        }

        // determine if the post is sold
        if (Objects.equals(requestModel.getPost().getStatus(), "Sold")) {
            return tradeOutputBoundry.prepareFailView("Item already sold.");
        }

        // calculate the new balance of buyer and seller after the transaction
        double buyerOldBalance = userDsGateway.getBalance(requestModel.getBuyerUsername());
        double sellerOldBalance = userDsGateway.getBalance(requestModel.getSellerUsername());
        double buyerNewBalance = buyerOldBalance - requestModel.getPost().getPrice();
        double sellerNewBalance = sellerOldBalance + requestModel.getPost().getPrice();

        // change the balance of buyer and seller to the new balance in database
        userDsGateway.changeBalance(requestModel.getBuyerUsername(), buyerNewBalance);
        userDsGateway.changeBalance(requestModel.getSellerUsername(), sellerNewBalance);

        // create a new Order entity
        Order order = orderFactory.create(requestModel.getPost(), requestModel.getCreationTimeString(),
                requestModel.getName(), requestModel.getAddress(), requestModel.getPhoneNumber(), "Shipped",
                requestModel.getBuyerUsername(), requestModel.getSellerUsername());

        // create the OrderDsRequestModel to be saved in database
        OrderDsRequestModel orderDsModel = new OrderDsRequestModel(order.getPost().getTitle(), order.getCreationTime(),
                order.getPost().getPrice(), order.getName(), order.getAddress(), order.getPhoneNumber(),
                order.getShipmentStatus(), order.getBuyerUsername(), order.getSellerUsername(),
                order.getPost().getTags());

        // set the status of the post being purchased to sold
        requestModel.getPost().setSold();

        // save the order to database
        orderDsGateway.save(orderDsModel);

        // display success transaction message to user
        TradeResponseModel tradeResponseModel = new TradeResponseModel("Order Confirmed", order.getCreationTime());
        return tradeOutputBoundry.prepareSuccessView(tradeResponseModel);

    }
}
