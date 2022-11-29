package use_case;

import entities.Account;
import entities.AccountFactory;

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

        Account account = accountFactory.create(requestModel.getUsername(), requestModel.getPassword());
        if (!account.passwordIsValid()) {
            return userRegisterOutputBoundry.prepareFailView("Password does not satisfy the criteria.");
        }
        LocalDateTime now = LocalDateTime.now();
        UserRegisterDsRequestModel userRegisterDsRequestModel = new UserRegisterDsRequestModel(account.getUsername(), account.getPassword(), now);
        userDsGateway.save(userRegisterDsRequestModel);

        UserRegisterResponseModel accountResponseModel = new UserRegisterResponseModel(account.getUsername(), now.toString());
        return userRegisterOutputBoundry.prepareSuccessView(accountResponseModel);
    }
}
