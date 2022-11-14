package use_case;

import gateway.TradeDsGateway;

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
