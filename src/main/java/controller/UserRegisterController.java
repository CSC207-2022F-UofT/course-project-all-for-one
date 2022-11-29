package controller;

import use_case.UserRegisterInputBoundary;
import use_case.UserRegisterResponseModel;
import use_case.UserRegisterRequestModel;

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
