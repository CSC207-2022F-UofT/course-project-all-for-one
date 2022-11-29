package use_case;

import entities.Account;
import entities.AccountFactory;

import java.time.LocalDateTime;

public class UserLoginInteractor implements UserLoginInputBoundary {

    final UserDsGateway userLoginDsGateway;
    final UserLoginPresenter userLoginPresenter;
    final AccountFactory accountFactory;

    public UserLoginInteractor(UserDsGateway userLoginDsGateway, UserLoginPresenter userLoginPresenter, AccountFactory accountFactory){
        this.userLoginDsGateway = userLoginDsGateway;
        this.userLoginPresenter = userLoginPresenter;
        this.accountFactory = accountFactory;
    }

    @Override
    public UserLoginResponseModel create(UserLoginRequestModel requestModel) {
        if (!userLoginDsGateway.existsByName(requestModel.getUsername())||
        !userLoginDsGateway.isPasswordCorrect(requestModel.getUsername(), requestModel.getPassword())){
            return userLoginPresenter.prepareFailView("Your username or password is not valid.");
        }

        Account account = accountFactory.create(requestModel.getUsername(), requestModel.getPassword());
        account.setLoginStatus(true);

        LocalDateTime now = LocalDateTime.now();
        UserLoginDsRequestModel userLoginDsRequestModel = new UserLoginDsRequestModel(account.getUsername(), account.getPassword(), now);
        userLoginDsGateway.save(userLoginDsRequestModel);
        UserLoginResponseModel responseModel = new UserLoginResponseModel(account.getUsername(), now.toString());
        return userLoginPresenter.prepareSuccessView(responseModel);
    }
}
