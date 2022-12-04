package application_business_rules_layer.userUseCases;

public interface UserRegisterOutputBoundary {
    UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user);

    UserRegisterResponseModel prepareFailView(String error);
}
