package use_case;

import entity.Order;
import entity.OrderFactory;
import gateway.TradeDsGateway;
import presenter.TradePresenter;

import java.time.LocalDateTime;

public class TradeInteractor implements TradeInputBoundry {

    final TradeDsGateway tradeDsGateway;
    final TradePresenter tradePresenter;
    final OrderFactory orderFactory;




    public TradeInteractor(TradeDsGateway tradeDsGateway, TradePresenter tradePresenter, OrderFactory orderFactory) {
        this.tradeDsGateway = tradeDsGateway;
        this.tradePresenter = tradePresenter;
        this.orderFactory = orderFactory;
    }

    @Override
    public TradeResponseModel create(TradeRequestModel requestModel) {

        Order order = OrderFactory.create(requestModel.getPostNumber(), requestModel.getPostTitle(), requestModel.getFinalPrice(),
                requestModel.getCreationTime(), requestModel.getName(),
                requestModel.getAddress(), requestModel.getPhoneNumber());

        LocalDateTime now = LocalDateTime.now();
        TradeResponseModel tradeResponseModel = new TradeResponseModel("Order Confirmed", now.toString());
        return tradePresenter.prepareSuccessView(tradeResponseModel);

    }
}
