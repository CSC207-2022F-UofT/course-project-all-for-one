package presenter;

import use_case.TradeResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface adapters layer

public class TradeResponsePresenter implements TradePresenter {

    @Override
    public TradeResponseModel prepareSuccessView(TradeResponseModel response) {
        return response;
    }


}
