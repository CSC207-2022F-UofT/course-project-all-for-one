package presenter;

import UI.TradeFailed;
import use_case.TradeResponseModel;

public class TradePresenter {
    public TradeResponseModel prepareSuccessView(TradeResponseModel responseModel) {

        return responseModel;
    }

    public TradeResponseModel prepareFailView(String error) {
        throw new TradeFailed(error);
    }


}

