package application_business_rules_layer.tradeUseCases;

public interface TradeOutputBoundry {
    TradeResponseModel prepareSuccessView(TradeResponseModel responseModel);

    TradeResponseModel prepareFailView(String error);
}
