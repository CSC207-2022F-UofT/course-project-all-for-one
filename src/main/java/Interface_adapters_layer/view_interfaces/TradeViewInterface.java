package Interface_adapters_layer.view_interfaces;

import application_business_rules_layer.tradeUseCases.TradeResponseModel;

public interface TradeViewInterface {

    void showSuccessMessage(TradeResponseModel responseModel);
}
