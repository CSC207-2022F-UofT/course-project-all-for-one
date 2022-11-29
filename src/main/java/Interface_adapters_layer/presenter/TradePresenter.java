package Interface_adapters_layer.presenter;

import framworks_drivers_layer.views.TradeFailed;
import application_business_rules_layer.tradeUseCases.TradeOutputBoundry;
import application_business_rules_layer.tradeUseCases.TradeResponseModel;

public class TradePresenter implements TradeOutputBoundry {
    @Override
    public TradeResponseModel prepareSuccessView(TradeResponseModel responseModel) {

        return responseModel;
    }

    @Override
    public TradeResponseModel prepareFailView(String error) {
        throw new TradeFailed(error);
    }


}

