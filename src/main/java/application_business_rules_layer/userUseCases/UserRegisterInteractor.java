package application_business_rules_layer.userUseCases;

import enterprise_business_rules_layer.Wallet;
import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.accountEntities.AccountFactory;

import java.time.LocalDateTime;

public class UserRegisterInteractor implements UserRegisterInputBoundary {

    final UserDsGateway userDsGateway;
    final UserRegisterOutputBoundry userRegisterOutputBoundry;
    final AccountFactory accountFactory;

    public UserRegisterInteractor(UserDsGateway userDsGateway, UserRegisterOutputBoundry userRegisterOutputBoundry1,
                                  AccountFactory accountFactory) {
        this.userDsGateway = userDsGateway;
        this.userRegisterOutputBoundry = userRegisterOutputBoundry1;
        this.accountFactory = accountFactory;
    }

    @Override
    public UserRegisterResponseModel create(UserRegisterRequestModel requestModel) {
        if (userDsGateway.existsByName(requestModel.getUsername())){
            return userRegisterOutputBoundry.prepareFailView("Username already exists.");
        } else if (!requestModel.getPassword().equals(requestModel.getRepeatedPassword())) {
            return userRegisterOutputBoundry.prepareFailView("Passwords don't match.");
        }

        Wallet wallet = new Wallet(1000);
        Account account = accountFactory.create(requestModel.getUsername(), requestModel.getPassword(), wallet);
        LocalDateTime now = LocalDateTime.now();
        UserDsRequestModel userDsRequestModel = new UserDsRequestModel(account.getUsername(), account.getPassword(), now,
                account.getWallet().getBalance());
        userDsGateway.save(userDsRequestModel);

        UserRegisterResponseModel accountResponseModel = new UserRegisterResponseModel(account.getUsername(), now.toString());
        return userRegisterOutputBoundry.prepareSuccessView(accountResponseModel);
    }
}
