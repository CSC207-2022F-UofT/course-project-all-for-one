package use_case;

import entity.Order;
import entity.OrderFactory;

import gateway.TradeDsGateway;
import presenter.TradePresenter;
import presenter.TradeResponsePresenter;

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

        Order order = OrderFactory.create(requestModel.getOrder());
        return tradePresenter.prepareSuccessView();

    }
}
