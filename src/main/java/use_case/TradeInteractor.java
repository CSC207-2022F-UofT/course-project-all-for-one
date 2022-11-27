package use_case;

import entities.Order;
import entities.OrderFactory;
import gateway.OrderDsGateway;
import presenter.TradePresenter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TradeInteractor implements TradeInputBoundry {

    final OrderDsGateway orderDsGateway;
    final TradePresenter tradePresenter;
    final OrderFactory orderFactory;




    public TradeInteractor(OrderDsGateway orderDsGateway, TradePresenter tradePresenter1, OrderFactory orderFactory1) {
        this.orderDsGateway = orderDsGateway;
        this.tradePresenter = tradePresenter1;
        this.orderFactory = orderFactory1;
    }

    @Override
    public TradeResponseModel create(TradeRequestModel requestModel) {
        if (requestModel.getBuyer().getWallet().getBalance() < requestModel.getPost().getPrice()) {
            return tradePresenter.prepareFailView("Insufficient balance.");
        }

        if (Objects.equals(requestModel.getPost().getStatus(), "Sold")) {
            return tradePresenter.prepareFailView("Item already sold.");
        }

        requestModel.getBuyer().getWallet().subtractBalance(requestModel.getPost().getPrice());

        requestModel.getSeller().getWallet().addBalance(requestModel.getPost().getPrice());

        LocalDateTime now = LocalDateTime.now();
        String creationTime = now.format(DateTimeFormatter.ofPattern("hh:mm:ss"));

        Order order = OrderFactory.create(requestModel.getPost(), creationTime, requestModel.getName(),
                requestModel.getAddress(), requestModel.getPhoneNumber(), "Shipped",
                requestModel.getBuyerUsername(), requestModel.getBuyerUsername());

        OrderDsRequestModel orderDsModel = new OrderDsRequestModel(order.getPost().getTitle(), now,
                order.getPost().getPrice(), order.getName(), order.getAddress(), order.getPhoneNumber(),
                order.getShipmentStatus(), order.getBuyerUsername(), order.getSellerUsername());

        requestModel.getPost().setSold();

        orderDsGateway.save(orderDsModel);

        TradeResponseModel tradeResponseModel = new TradeResponseModel("Order Confirmed", creationTime);
        return tradePresenter.prepareSuccessView(tradeResponseModel);

    }
}
