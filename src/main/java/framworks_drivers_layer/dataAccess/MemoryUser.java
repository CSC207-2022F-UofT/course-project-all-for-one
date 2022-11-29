package framworks_drivers_layer.dataAccess;

import application_business_rules_layer.userUseCases.UserLoginDsGateway;
import application_business_rules_layer.userUseCases.UserRegisterDsGateway;
import application_business_rules_layer.userUseCases.UserRegisterDsRequestModel;

import java.util.HashMap;
import java.util.Map;

public class MemoryUser implements UserLoginDsGateway {

    final private Map<String, UserRegisterDsRequestModel> accounts = new HashMap<>();

    /**
     * @param identifier the user's username
     * @return whether the user exists
     */

    @Override
    public boolean isPasswordCorrect (String username, String password) {
        return accounts.get(username).equals(password);
    }

    @Override
    public String getPassword(String username) {
        return accounts.get(username).getPassword();
    }

    @Override
    public String getBalance(String username) {
        return accounts.get(username).getWalletBalance();
    }


}
