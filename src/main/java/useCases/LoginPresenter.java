package useCases;

public interface LoginPresenter {
    LoginResponseModel prepareSuccessView(LoginResponseModel user);

    LoginResponseModel prepareFailView(String error);
}
