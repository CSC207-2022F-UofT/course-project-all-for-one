package application_business_rules_layer.tradeUseCases;

public class TradeResponseModel {
    private final String SuccessMessage;

    private final String TradeTime;

    public TradeResponseModel(String successMessage, String creationTime) {
        this.SuccessMessage = successMessage;
        this.TradeTime = creationTime;
    }

    /**
     *
     * @return the message that the transaction is successful
     */
    public String getSuccessMessage() {
        return this.SuccessMessage;
    }

    /**
     *
     * @return the time of the transaction
     */
    public String getCreationTime() {
        return this.TradeTime;
    }
}
