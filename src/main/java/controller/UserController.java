package controller;

import use_case.UserInputBoundary;
import use_case.UserRequestModel;
import use_case.UserResponseModel;

import java.awt.event.ActionEvent;

public class UserController {
    final UserInputBoundary userInput;

    public UserController(UserInputBoundary usergateway) {
        this.userInput = usergateway;
    }

    UserResponseModel create(ActionEvent e){
        UserRequestModel requestmodel = new UserRequestModel(e);
        return userInput.create(requestmodel);
    }

}
