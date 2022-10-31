package trade_use_case;

public interface TradeInputBoundary {
    TradeResponseModel create(TradeRequestModel requestModel);
}
