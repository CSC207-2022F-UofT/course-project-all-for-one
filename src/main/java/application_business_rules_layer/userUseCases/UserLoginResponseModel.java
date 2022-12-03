package application_business_rules_layer.userUseCases;

import Interface_adapters_layer.controller.RecommendationController;
import Interface_adapters_layer.controller.UserLoginController;
import application_business_rules_layer.postUseCases.PostDsGateway;
import application_business_rules_layer.recommendationUseCases.RecommendationInputBoundry;
import application_business_rules_layer.recommendationUseCases.RecommendationOutputBoundry;
import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.accountEntities.AccountFactory;

public class UserLoginResponseModel {
    Account user;

    RecommendationOutputBoundry recommendationOutputBoundry;

    PostDsGateway postDsGateway;

    RecommendationInputBoundry recommendationInputBoundry;

    OrderDsGateway orderDsGateway;



    public UserLoginResponseModel(Account user, RecommendationOutputBoundry recommendationOutputBoundry,
                                  PostDsGateway postDsGateway, RecommendationInputBoundry recommendationInputBoundry,
                                  OrderDsGateway orderDsGateway) {
        this.user = user;
        this.recommendationOutputBoundry = recommendationOutputBoundry;
        this.postDsGateway = postDsGateway;
        this.recommendationInputBoundry = recommendationInputBoundry;
        this.orderDsGateway = orderDsGateway;

    }


    public Account getUser() {
        return this.user;
    }

    public RecommendationOutputBoundry getRecommendationOutputBoundry() {
        return recommendationOutputBoundry;
    }

    public PostDsGateway getPostDsGateway() {
        return postDsGateway;
    }

    public RecommendationInputBoundry getRecommendationInputBoundry() {
        return recommendationInputBoundry;
    }

    public OrderDsGateway getOrderDsGateway() {
        return orderDsGateway;
    }


}
