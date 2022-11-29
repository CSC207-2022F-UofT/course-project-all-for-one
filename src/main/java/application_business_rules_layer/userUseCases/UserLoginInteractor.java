package application_business_rules_layer.userUseCases;

import enterprise_business_rules_layer.Wallet;
import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.accountEntities.AccountFactory;

import java.time.LocalDateTime;

public class UserLoginInteractor implements UserLoginInputBoundary {

    final UserDsGateway userLoginDsGateway;
    final UserLoginOutputBoundary userLoginOutputBoundary;
    final AccountFactory accountFactory;

    public UserLoginInteractor(UserDsGateway userLoginDsGateway, UserLoginOutputBoundary userLoginOutputBoundary1, AccountFactory accountFactory){
        this.userLoginDsGateway = userLoginDsGateway;
        this.userLoginOutputBoundary = userLoginOutputBoundary1;
        this.accountFactory = accountFactory;
    }

    @Override
    public UserLoginResponseModel create(UserLoginRequestModel requestModel) {
        if (!userLoginDsGateway.existsByName(requestModel.getUsername())||
        !userLoginDsGateway.isPasswordCorrect(requestModel.getUsername(), requestModel.getPassword())){
            return userLoginOutputBoundary.prepareFailView("Your username or password is not valid.");
        }
        Double balance = userLoginDsGateway.getBalance(requestModel.getUsername());
        Wallet wallet = new Wallet(balance);

        Account account = accountFactory.create(requestModel.getUsername(), requestModel.getPassword(),wallet);
        account.setLoginStatus(true);


        UserLoginResponseModel responseModel = new UserLoginResponseModel(account);
        return userLoginOutputBoundary.prepareSuccessView(responseModel);
    }
}
