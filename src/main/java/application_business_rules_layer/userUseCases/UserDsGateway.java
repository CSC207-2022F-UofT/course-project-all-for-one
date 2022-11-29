package application_business_rules_layer.userUseCases;

import enterprise_business_rules_layer.accountEntities.Account;

public interface UserDsGateway {
    boolean existsByName(String username);

    boolean isPasswordCorrect (String username, String password);

    String getPassword (String username);

    void save(UserRegisterDsRequestModel requestModel);


}
