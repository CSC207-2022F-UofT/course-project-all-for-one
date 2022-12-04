package application_business_rules_layer.tradeUseCases;

public interface TradeOutputBoundry {

    /**
     *
     * @param responseModel TradeResponseModel after processing by the use case
     * @return user interface indicating that the order has been placed
     */
    TradeResponseModel prepareSuccessView(TradeResponseModel responseModel);

    /**
     *
     * @param error String that describe the error type
     * @return user interface indicating that the traction has failed due to error
     */
    TradeResponseModel prepareFailView(String error);
}
