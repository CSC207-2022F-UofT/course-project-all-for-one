package application_business_rules_layer.tradeUseCases;

public interface TradeInputBoundary {

    /**
     *
     * @param requestModel TradeRequestModel that serves as the input needed for processing
     * @return TradeResponseModel object that contains output after processing
     */
    TradeResponseModel create(TradeRequestModel requestModel);
}
