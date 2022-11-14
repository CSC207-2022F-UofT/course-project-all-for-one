package useCases;

import entities.Account;
import entities.AccountFactory;

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
    //TODO implement it
    @Override
    public RegisterResponseModel create(RegisterRequestModel requestModel) {
        return null;
    }
}
