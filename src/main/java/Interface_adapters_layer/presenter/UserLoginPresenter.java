package Interface_adapters_layer.presenter;


import application_business_rules_layer.userUseCases.UserLoginOutputBoundary;
import application_business_rules_layer.userUseCases.UserLoginResponseModel;
import framworks_drivers_layer.views.UserLoginFailed;


public class UserLoginPresenter implements UserLoginOutputBoundary {

    /**
     *
     * @param error the type of error
     * @return the error message
     */
    @Override
    public UserLoginResponseModel prepareFailView(String error) {
        throw new UserLoginFailed(error);
    }


}
