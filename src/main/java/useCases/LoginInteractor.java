package useCases;

import entities.Account;
import entities.AccountFactory;

public class LoginInteractor implements LoginInputBoundary{

    final LoginDsGateway loginDsGateway;
    final LoginPresenter loginPresenter;
    final AccountFactory accountFactory;

    public LoginInteractor(LoginDsGateway loginDsGateway, LoginPresenter loginPresenter, AccountFactory accountFactory){
        this.loginDsGateway = loginDsGateway;
        this.loginPresenter = loginPresenter;
        this.accountFactory = accountFactory;
    }
    //TODO implement it
    @Override
    public LoginResponseModel create(LoginRequestModel requestModel) {
        if (!loginDsGateway.isExistedName(requestModel.getUsername())||
        !loginDsGateway.isPasswordCorrect(requestModel.getUsername(), requestModel.getPassword())){
            return loginPresenter.prepareFailView("Your username or password is not valid.");
        }

        Account account = accountFactory.create(requestModel.getUsername(), requestModel.getPassword());
        LoginResponseModel responseModel = new LoginResponseModel();
        return loginPresenter.prepareSuccessView(responseModel);
    }
}
