package controller;

import use_case.UserLoginInputBoundary;
import use_case.UserLoginResponseModel;
import use_case.UserLoginRequestModel;

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
