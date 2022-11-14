package useCases;

public interface RegisterPresenter {
    RegisterResponseModel prepareSuccessView(RegisterResponseModel user);

    RegisterResponseModel prepareFailView(String error);
}
