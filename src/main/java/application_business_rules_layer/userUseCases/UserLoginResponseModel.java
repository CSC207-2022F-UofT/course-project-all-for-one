package application_business_rules_layer.userUseCases;

import application_business_rules_layer.recommendationUseCases.RecommendationInputBoundry;
import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import enterprise_business_rules_layer.accountEntities.Account;

public class UserLoginResponseModel {

    String username;
    RecommendationInputBoundry recommendationInputBoundry;

    OrderDsGateway orderDsGateway;

    public UserLoginResponseModel(String username, RecommendationInputBoundry recommendationInputBoundry,
                                  OrderDsGateway orderDsGateway) {
        this.username = username;
        this.recommendationInputBoundry = recommendationInputBoundry;
        this.orderDsGateway = orderDsGateway;
    }

    /**
     *
     * @return the username after processing by the use case
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return RecommendationInputBoundary object after processing
     */
    public RecommendationInputBoundry getRecommendationInputBoundry() {
        return recommendationInputBoundry;
    }

    /**
     *
     * @return OrderDsGateway object after processing
     */
    public OrderDsGateway getOrderDsGateway() {
        return orderDsGateway;
    }


}
