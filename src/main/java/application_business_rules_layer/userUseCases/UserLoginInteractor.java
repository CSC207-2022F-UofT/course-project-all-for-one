package application_business_rules_layer.userUseCases;

import Interface_adapters_layer.presenter.RecommendationResponsePresenter;
import application_business_rules_layer.postUseCases.PostDsGateway;
import application_business_rules_layer.recommendationUseCases.RecommendationInputBoundry;
import application_business_rules_layer.recommendationUseCases.RecommendationInteractor;
import application_business_rules_layer.recommendationUseCases.RecommendationOutputBoundry;
import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import enterprise_business_rules_layer.Wallet;
import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.accountEntities.AccountFactory;
import framworks_drivers_layer.dataAccess.FileOrder;
import framworks_drivers_layer.dataAccess.FilePost;

import java.io.IOException;

public class UserLoginInteractor implements UserLoginInputBoundary {

    final UserDsGateway userDsGateway;
    final UserLoginOutputBoundary userLoginOutputBoundary;
    final AccountFactory accountFactory;

    /**
     *
     * @param userDsGateway Interface_adapters.gateway to reach user database
     * @param userLoginOutputBoundary relay to Interface_adapters.presenter
     * @param accountFactory factory to create User entity
     */
    public UserLoginInteractor(UserDsGateway userDsGateway, UserLoginOutputBoundary userLoginOutputBoundary,
                               AccountFactory accountFactory){
        this.userDsGateway = userDsGateway;
        this.userLoginOutputBoundary = userLoginOutputBoundary;
        this.accountFactory = accountFactory;
    }

    /**
     *
     * @param requestModel UserLoginRequestModel that serves as the input needed for processing
     * @return UserLoginResponseModel object that contains needed objects for user interface.
     */
    @Override
    public UserLoginResponseModel create(UserLoginRequestModel requestModel) {
        if(!userDsGateway.existsByName(requestModel.getUsername())){
            return userLoginOutputBoundary.prepareFailView("Your username does not exist.");
        }
        // determine if the password user input match with the password of the username in the database
        if (!userDsGateway.isPasswordCorrect(requestModel.getUsername(), requestModel.getPassword())
        ){
            return userLoginOutputBoundary.prepareFailView("Your username or password is not valid.");
        }

        // create an Account entity
        double balance = userDsGateway.getBalance(requestModel.getUsername());
        Wallet wallet = new Wallet(balance);
        Account account = accountFactory.create(requestModel.getUsername(), requestModel.getPassword(),wallet);

        // initialize objects for UserLoginResponseModel
        RecommendationOutputBoundry recommendationOutputBoundry = new RecommendationResponsePresenter();
        PostDsGateway post;
        try {
            post = new FilePost("./posts.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create posts.csv.");
        }
        RecommendationInputBoundry recommendationInputBoundry = new RecommendationInteractor(recommendationOutputBoundry, post);
        OrderDsGateway orderDsGateway;
        try{
            orderDsGateway = new FileOrder("./orders.csv");
        } catch (IOException e){
            throw new RuntimeException("Could not create orders.csv");
        }

        return new UserLoginResponseModel(requestModel.getUsername(), recommendationInputBoundry, orderDsGateway);
    }
}
