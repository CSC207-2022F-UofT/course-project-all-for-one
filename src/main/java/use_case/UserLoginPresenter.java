package use_case;

public interface UserLoginPresenter {
    UserLoginResponseModel prepareSuccessView(UserLoginResponseModel user);

    UserLoginResponseModel prepareFailView(String error);
}