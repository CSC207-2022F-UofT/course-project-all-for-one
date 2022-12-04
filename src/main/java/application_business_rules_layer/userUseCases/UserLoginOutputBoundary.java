package application_business_rules_layer.userUseCases;

public interface UserLoginOutputBoundary {
    UserLoginResponseModel prepareSuccessView(UserLoginResponseModel responseModel);

    UserLoginResponseModel prepareFailView(String error);
}
