package application_business_rules_layer.userUseCases;

import enterprise_business_rules_layer.Wallet;
import enterprise_business_rules_layer.accountEntities.Account;
import enterprise_business_rules_layer.accountEntities.AccountFactory;

import java.time.LocalDateTime;

public class UserRegisterInteractor implements UserRegisterInputBoundary {

    final UserDsGateway userDsGateway;
    final UserRegisterOutputBoundary userRegisterOutputBoundary;
    final AccountFactory accountFactory;

    /**
     *
     * @param userDsGateway Interface_adapters.gateway to reach user database
     * @param userRegisterOutputBoundary relay to Interface_adapters.presenter
     * @param accountFactory factory to create Account entity
     */
    public UserRegisterInteractor(UserDsGateway userDsGateway, UserRegisterOutputBoundary userRegisterOutputBoundary,
                                  AccountFactory accountFactory) {
        this.userDsGateway = userDsGateway;
        this.userRegisterOutputBoundary = userRegisterOutputBoundary;
        this.accountFactory = accountFactory;
    }

    @Override
    public UserRegisterResponseModel create(UserRegisterRequestModel requestModel) {

        // determine if the username already existed in the database
        if (userDsGateway.existsByName(requestModel.getUsername())){
            return userRegisterOutputBoundary.prepareFailView("Username already exists.");
        }

        // determine if the two passwords user input are the same
        else if (!requestModel.getPassword().equals(requestModel.getRepeatedPassword())) {
            return userRegisterOutputBoundary.prepareFailView("Passwords don't match.");
        }

        Wallet wallet = new Wallet(1000);
        Account account = accountFactory.create(requestModel.getUsername(), requestModel.getPassword(), wallet);
        LocalDateTime now = LocalDateTime.now();
        UserDsRequestModel userDsRequestModel = new UserDsRequestModel(account.getUsername(), account.getPassword(), now,
                account.getWallet().getBalance());
        userDsGateway.save(userDsRequestModel);

        UserRegisterResponseModel accountResponseModel = new UserRegisterResponseModel(account.getUsername(), now.toString());
        return accountResponseModel;
    }
}
