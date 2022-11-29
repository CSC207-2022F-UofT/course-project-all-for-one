package application_business_rules_layer.tradeUseCases;

public interface TradeInputBoundry {
    TradeResponseModel create(TradeRequestModel requestModel);
}
