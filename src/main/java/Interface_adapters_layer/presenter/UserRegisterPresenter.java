package Interface_adapters_layer.presenter;

import framworks_drivers_layer.views.UserCreationFailed;
import application_business_rules_layer.userUseCases.UserRegisterOutputBoundary;
import application_business_rules_layer.userUseCases.UserRegisterResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserRegisterPresenter implements UserRegisterOutputBoundary {
    @Override
    public UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    @Override
    public UserRegisterResponseModel prepareFailView(String error) {
        throw new UserCreationFailed(error);
    }
}
