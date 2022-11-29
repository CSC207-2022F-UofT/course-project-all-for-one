package Interface_adapters_layer.controller;

import application_business_rules_layer.userUseCases.UserLoginInputBoundary;
import application_business_rules_layer.userUseCases.UserLoginResponseModel;
import application_business_rules_layer.userUseCases.UserLoginRequestModel;
import enterprise_business_rules_layer.Wallet;

// Interface adapters layer

public class UserLoginController {

    final UserLoginInputBoundary userInput;

    public UserLoginController(UserLoginInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public UserLoginResponseModel create(String username, String password) {
        UserLoginRequestModel requestModel = new UserLoginRequestModel(
                username, password);

        return userInput.create(requestModel);
    }
}
