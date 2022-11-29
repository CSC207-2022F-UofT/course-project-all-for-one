package Interface_adapters_layer.presenter;

import Interface_adapters_layer.controller.RecommendationController;
import application_business_rules_layer.recommendationUseCases.RecommendationInputBoundry;
import application_business_rules_layer.recommendationUseCases.RecommendationInteractor;
import application_business_rules_layer.userUseCases.UserLoginOutputBoundary;
import application_business_rules_layer.userUseCases.UserLoginResponseModel;
import enterprise_business_rules_layer.Recommendation;
import framworks_drivers_layer.views.UserLoginFailed;

public class UserLoginPresenter implements UserLoginOutputBoundary {

    @Override
    public UserLoginResponseModel prepareSuccessView(UserLoginResponseModel response) {
        return response;


    }
    @Override
    public UserLoginResponseModel prepareFailView(String error) {
        throw new UserLoginFailed(error);
    }


}
