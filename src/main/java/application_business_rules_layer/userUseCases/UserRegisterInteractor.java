package application_business_rules_layer.userUseCases;

import enterprise_business_rules_layer.Wallet;
import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.accountEntities.AccountFactory;

import java.time.LocalDateTime;

public class UserRegisterInteractor implements UserRegisterInputBoundary {

    final UserRegisterDsGateway userRegisterDsGateway;
    final UserRegisterOutputBoundry userRegisterOutputBoundry;
    final AccountFactory accountFactory;

    public UserRegisterInteractor(UserRegisterDsGateway userRegisterDsGateway, UserRegisterOutputBoundry userRegisterOutputBoundry1,
                                  AccountFactory accountFactory) {
        this.userRegisterDsGateway = userRegisterDsGateway;
        this.userRegisterOutputBoundry = userRegisterOutputBoundry1;
        this.accountFactory = accountFactory;
    }

    @Override
    public UserRegisterResponseModel create(UserRegisterRequestModel requestModel) {
        if (userRegisterDsGateway.existsByName(requestModel.getUsername())){
            return userRegisterOutputBoundry.prepareFailView("Username already exists.");
        } else if (!requestModel.getPassword().equals(requestModel.getRepeatedPassword())) {
            return userRegisterOutputBoundry.prepareFailView("Passwords don't match.");
        }

        Wallet wallet = new Wallet(1000);
        Account account = accountFactory.create(requestModel.getUsername(), requestModel.getPassword(), wallet);
        LocalDateTime now = LocalDateTime.now();
        UserRegisterDsRequestModel userRegisterDsRequestModel = new UserRegisterDsRequestModel(account.getUsername(), account.getPassword(), now,
                account.getWallet().getBalanceString());
        userRegisterDsGateway.save(userRegisterDsRequestModel);

        UserRegisterResponseModel accountResponseModel = new UserRegisterResponseModel(account.getUsername(), now.toString());
        return userRegisterOutputBoundry.prepareSuccessView(accountResponseModel);
    }
}
