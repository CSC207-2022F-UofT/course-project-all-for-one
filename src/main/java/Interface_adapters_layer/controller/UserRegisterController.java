package Interface_adapters_layer.controller;

import application_business_rules_layer.userUseCases.UserRegisterInputBoundary;
import application_business_rules_layer.userUseCases.UserRegisterResponseModel;
import application_business_rules_layer.userUseCases.UserRegisterRequestModel;

// Interface adapters layer

public class UserRegisterController {

    final UserRegisterInputBoundary userInput;

    public UserRegisterController(UserRegisterInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public UserRegisterResponseModel create(String username, String password1, String password2) {
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                username, password1, password2);

        return userInput.create(requestModel);
    }
}
