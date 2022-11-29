package use_case;

public interface UserLoginInputBoundary {
    UserLoginResponseModel create(UserLoginRequestModel requestModel);
}
