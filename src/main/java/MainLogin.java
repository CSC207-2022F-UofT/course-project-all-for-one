import Interface_adapters_layer.controller.UserLoginController;
import Interface_adapters_layer.presenter.UserLoginPresenter;
import application_business_rules_layer.userUseCases.UserDsGateway;
import application_business_rules_layer.userUseCases.UserLoginInputBoundary;
import application_business_rules_layer.userUseCases.UserLoginInteractor;
import application_business_rules_layer.userUseCases.UserLoginOutputBoundary;
import enterprise_business_rules_layer.accountEntities.AccountFactory;
import framworks_drivers_layer.dataAccess.FileUser;
import framworks_drivers_layer.views.UserLoginScreen;

import java.io.IOException;

public class MainLogin {
    public static void main(String[] args) {

        // Build the main program window

        // Create the parts to plug into the Use Case+Entities engine
        UserDsGateway user;
        try {
            user = new FileUser("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        UserLoginOutputBoundary presenter = new UserLoginPresenter();
        AccountFactory accountFactory = new AccountFactory();
        UserLoginInputBoundary interactor = new UserLoginInteractor(
                user, presenter, accountFactory);
        UserLoginController controller = new UserLoginController(interactor);

        // Build the GUI, plugging in the parts
        UserLoginScreen loginScreen = new UserLoginScreen(controller);


        loginScreen.setVisible(true);

    }

}