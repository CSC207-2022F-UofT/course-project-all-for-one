package application_business_rules_layer.userUseCases;

public interface UserDsGateway {
    boolean existsByName(String username);

    boolean isPasswordCorrect (String username, String password);

    String getPassword (String username);

    double getBalance (String username);

    void save(UserRegisterDsRequestModel requestModel);


}
