package application_business_rules_layer.userUseCases;

public interface UserLoginDsGateway {
    boolean isPasswordCorrect (String username, String password);

    String getPassword (String username);

    double getBalance (String username);
}
