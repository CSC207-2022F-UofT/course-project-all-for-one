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

    UserDsGateway userDsGateway;

    UserRegisterOutputBoundary userRegisterOutputBoundary;

    UserRegisterInputBoundary userRegisterInputBoundary;

    AccountFactory accountFactory;

    public UserLoginResponseModel(Account user, RecommendationOutputBoundry recommendationOutputBoundry,
                                  PostDsGateway postDsGateway, RecommendationInputBoundry recommendationInputBoundry,
                                  OrderDsGateway orderDsGateway, UserDsGateway userDsGateway,
                                  UserRegisterOutputBoundary userRegisterOutputBoundary,
                                  UserRegisterInputBoundary userRegisterInputBoundary,
                                  AccountFactory accountFactory) {
        this.user = user;
        this.recommendationOutputBoundry = recommendationOutputBoundry;
        this.postDsGateway = postDsGateway;
        this.recommendationInputBoundry = recommendationInputBoundry;
        this.orderDsGateway = orderDsGateway;
        this.userDsGateway = userDsGateway;
        this.userRegisterOutputBoundary = userRegisterOutputBoundary;
        this.userRegisterInputBoundary = userRegisterInputBoundary;
        this.accountFactory = accountFactory;
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

    public UserDsGateway getUserDsGateway() {
        return userDsGateway;
    }

    public UserRegisterOutputBoundary getUserRegisterOutputBoundary() {
        return userRegisterOutputBoundary;
    }

    public UserRegisterInputBoundary getUserRegisterInputBoundary() {
        return userRegisterInputBoundary;
    }

    public AccountFactory getAccountFactory() {
        return accountFactory;
    }
}
