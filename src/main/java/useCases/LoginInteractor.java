package useCases;

import entities.Account;
import entities.AccountFactory;

import java.time.LocalDateTime;

public class LoginInteractor implements LoginInputBoundary{

    final LoginDsGateway loginDsGateway;
    final LoginPresenter loginPresenter;
    final AccountFactory accountFactory;

    public LoginInteractor(LoginDsGateway loginDsGateway, LoginPresenter loginPresenter, AccountFactory accountFactory){
        this.loginDsGateway = loginDsGateway;
        this.loginPresenter = loginPresenter;
        this.accountFactory = accountFactory;
    }

    @Override
    public LoginResponseModel create(LoginRequestModel requestModel) {
        if (!loginDsGateway.isExistedName(requestModel.getUsername())||
        !loginDsGateway.isPasswordCorrect(requestModel.getUsername(), requestModel.getPassword())){
            return loginPresenter.prepareFailView("Your username or password is not valid.");
        }

        Account account = accountFactory.create(requestModel.getUsername(), requestModel.getPassword());
        account.setLoginStatus(true);

        LocalDateTime now = LocalDateTime.now();
        LoginDsRequestModel loginDsRequestModel = new LoginDsRequestModel(account.getUsername(), account.getPassword(), now);
        loginDsGateway.save(loginDsRequestModel);
        LoginResponseModel responseModel = new LoginResponseModel(account.getUsername(), now.toString());
        return loginPresenter.prepareSuccessView(responseModel);
    }
}
