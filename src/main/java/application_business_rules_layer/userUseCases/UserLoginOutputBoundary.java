package application_business_rules_layer.userUseCases;

public interface UserLoginOutputBoundary {

    UserLoginResponseModel prepareFailView(String error);
}
