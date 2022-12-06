package application_business_rules_layer.userUseCases;

public interface UserRegisterInputBoundary {

    /**
     *
     * @param requestModel UserRegisterRequestModel object that contains data to be processed by the use case
     * @return UserRegisterResponseModel object after processing by the use case
     */
    void create(UserRegisterRequestModel requestModel);
}
