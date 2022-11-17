package use_case;

import entity.Order;
import entity.OrderFactory;

import gateway.TradeDsGateway;
import presenter.TradeResponsePresenter;

public class BuyInteractor implements TradeInputBoundry {

    final TradeDsGateway tradeDsGateway;
    final TradeResponsePresenter tradeResponsePresenter;
    final OrderFactory orderFactory;




    public TradeInteractor(TradeDsGateway tradeDsGateway, TradeResponsePresenter tradeResponsePresenter) {
        this.tradeDsGateway = tradeDsGateway;
        this.tradeResponsePresenter = tradeResponsePresenter;
    }

    @Override
    public TradeResponseModel crete(TradeRequestModel requestModel) {

        Order order = OrderFactory.create(requestModel.getOrder());

    }
}
