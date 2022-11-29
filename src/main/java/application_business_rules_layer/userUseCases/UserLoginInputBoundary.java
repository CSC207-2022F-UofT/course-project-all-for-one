package application_business_rules_layer.userUseCases;

public interface UserLoginInputBoundary {
    UserLoginResponseModel create(UserLoginRequestModel requestModel);
}
