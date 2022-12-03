package Interface_adapters_layer.presenter;

import Interface_adapters_layer.controller.RecommendationController;
import application_business_rules_layer.postUseCases.PostDsGateway;
import application_business_rules_layer.recommendationUseCases.RecommendationInputBoundry;
import application_business_rules_layer.recommendationUseCases.RecommendationInteractor;
import application_business_rules_layer.recommendationUseCases.RecommendationOutputBoundry;
import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import application_business_rules_layer.userUseCases.UserLoginOutputBoundary;
import application_business_rules_layer.userUseCases.UserLoginResponseModel;
import enterprise_business_rules_layer.Recommendation;
import framworks_drivers_layer.dataAccess.FileOrder;
import framworks_drivers_layer.dataAccess.FilePost;
import framworks_drivers_layer.views.MainPage;
import framworks_drivers_layer.views.UserLoginFailed;

import javax.swing.*;
import java.io.IOException;

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
