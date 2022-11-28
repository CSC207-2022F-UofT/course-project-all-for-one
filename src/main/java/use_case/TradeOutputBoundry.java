package use_case;

public interface TradeOutputBoundry {
    TradeResponseModel prepareSuccessView(TradeResponseModel responseModel);

    TradeResponseModel prepareFailView(String error);
}
