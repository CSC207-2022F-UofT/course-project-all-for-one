package use_case;

public interface UserRegisterOutputBoundry {
    UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user);

    UserRegisterResponseModel prepareFailView(String error);
}
