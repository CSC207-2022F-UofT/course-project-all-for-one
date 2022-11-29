package application_business_rules_layer.userUseCases;

public interface UserRegisterOutputBoundry {
    UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user);

    UserRegisterResponseModel prepareFailView(String error);
}
