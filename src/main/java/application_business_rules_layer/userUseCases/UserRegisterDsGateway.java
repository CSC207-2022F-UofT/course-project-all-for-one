package application_business_rules_layer.userUseCases;

public interface UserRegisterDsGateway {
    boolean existsByName(String username);

    void save(UserRegisterDsRequestModel requestModel);


}
