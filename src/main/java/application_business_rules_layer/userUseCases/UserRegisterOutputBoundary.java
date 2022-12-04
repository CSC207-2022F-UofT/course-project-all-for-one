package application_business_rules_layer.userUseCases;

public interface UserRegisterOutputBoundary {

    /**
     *
     * @param error the type of error
     * @return the message that register failed due to error
     */
    UserRegisterResponseModel prepareFailView(String error);
}
