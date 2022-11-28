package presenter;

import UI.TradeFailed;
import use_case.TradeOutputBoundry;
import use_case.TradeResponseModel;

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

