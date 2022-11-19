package useCases;

import entities.Account;
import entities.AccountFactory;

import java.time.LocalDateTime;

public class RegisterInteractor implements RegisterInputBoundary{

    final RegisterDsGateway registerDsGateway;
    final RegisterPresenter registerPresenter;
    final AccountFactory accountFactory;

    public RegisterInteractor(RegisterDsGateway registerDsGateway, RegisterPresenter registerPresenter,
                                  AccountFactory accountFactory) {
        this.registerDsGateway = registerDsGateway;
        this.registerPresenter = registerPresenter;
        this.accountFactory = accountFactory;
    }

    @Override
    public RegisterResponseModel create(RegisterRequestModel requestModel) {
        if (registerDsGateway.isExistedName(requestModel.getUsername())){
            return registerPresenter.prepareFailView("Username already exists.");
        } else if (!requestModel.getPassword().equals(requestModel.getRepeatedPassword())) {
            return registerPresenter.prepareFailView("Passwords don't match.");
        }

        Account account = accountFactory.create(requestModel.getUsername(), requestModel.getPassword());
        if (!account.passwordIsValid()) {
            return registerPresenter.prepareFailView("Password does not satisfy the criteria.");
        }
        LocalDateTime now = LocalDateTime.now();
        RegisterDsRequestModel registerDsRequestModel = new RegisterDsRequestModel(account.getUsername(), account.getPassword(), now);
        registerDsGateway.save(registerDsRequestModel);

        RegisterResponseModel accountResponseModel = new RegisterResponseModel(account.getUsername(), now.toString());
        return registerPresenter.prepareSuccessView(accountResponseModel);
    }
}
