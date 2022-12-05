package Interface_adapters_layer.presenter;

import framworks_drivers_layer.views.UserCreationFailed;
import application_business_rules_layer.userUseCases.UserRegisterOutputBoundary;
//import application_business_rules_layer.userUseCases.UserRegisterResponseModel;

public class UserRegisterPresenter implements UserRegisterOutputBoundary {

    @Override
    public void prepareFailView(String error) {
        throw new UserCreationFailed(error);
    }
}
