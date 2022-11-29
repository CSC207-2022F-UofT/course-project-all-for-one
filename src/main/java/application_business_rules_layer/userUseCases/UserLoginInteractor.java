package application_business_rules_layer.userUseCases;

import enterprise_business_rules_layer.Wallet;
import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.accountEntities.AccountFactory;

public class UserLoginInteractor implements UserLoginInputBoundary {

    final UserLoginDsGateway userLoginDsGateway;
    final UserLoginOutputBoundary userLoginOutputBoundary;
    final AccountFactory accountFactory;

    public UserLoginInteractor(UserLoginDsGateway userLoginDsGateway, UserLoginOutputBoundary userLoginOutputBoundary1, AccountFactory accountFactory){
        this.userLoginDsGateway = userLoginDsGateway;
        this.userLoginOutputBoundary = userLoginOutputBoundary1;
        this.accountFactory = accountFactory;
    }

    @Override
    public UserLoginResponseModel create(UserLoginRequestModel requestModel) {
        if (!userLoginDsGateway.isPasswordCorrect(requestModel.getUsername(), requestModel.getPassword())){
            return userLoginOutputBoundary.prepareFailView("Your username or password is not valid.");
        }
        String balance = userLoginDsGateway.getBalance(requestModel.getUsername());
        Double balanceD = Double.parseDouble(balance);
        Wallet wallet = new Wallet(balanceD);

        Account account = accountFactory.create(requestModel.getUsername(), requestModel.getPassword(),wallet);
        account.setLoginStatus(true);


        UserLoginResponseModel responseModel = new UserLoginResponseModel(account);
        return userLoginOutputBoundary.prepareSuccessView(responseModel);
    }
}
