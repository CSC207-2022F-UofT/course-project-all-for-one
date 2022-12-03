package Interface_adapters_layer.presenter;

import framworks_drivers_layer.views.TradeFailed;
import application_business_rules_layer.tradeUseCases.TradeOutputBoundry;
import application_business_rules_layer.tradeUseCases.TradeResponseModel;

public class TradePresenter implements TradeOutputBoundry {

    /**
     *
     * @param responseModel TradeResponseModel after processing by the use case
     * @return
     */
    @Override
    public TradeResponseModel prepareSuccessView(TradeResponseModel responseModel) {

        return responseModel;
    }

    /**
     *
     * @param error String that describe the error type
     * @return the error
     */
    @Override
    public TradeResponseModel prepareFailView(String error) {
        throw new TradeFailed(error);
    }


}

