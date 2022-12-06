package framworks_drivers_layer.dataAccess;

import application_business_rules_layer.userUseCases.UserDsGateway;
import application_business_rules_layer.userUseCases.UserDsRequestModel;

import java.util.HashMap;
import java.util.Map;

public class MemoryUser implements UserDsGateway {
    final private Map<String, UserDsRequestModel> accounts = new HashMap<>();

    @Override
    public boolean existsByName(String username) {
        return accounts.containsKey(username);
    }

    @Override
    public boolean isPasswordCorrect (String username, String password) {
        return accounts.get(username).getPassword().equals(password);
    }

    @Override
    public String getPassword (String username) {
        return accounts.get(username).getPassword();
    }

    @Override
    public double getBalance(String username) {
        return accounts.get(username).getWalletBalance();
    }

    @Override
    public void changeBalance(String username, double newBalance) {
        System.out.println("Change balance to " + newBalance);
        accounts.get(username).setWalletBalance(newBalance);
    }

    @Override
    public void save(UserDsRequestModel requestModel) {
        System.out.println("Save " + requestModel.getName());
        accounts.put(requestModel.getName(), requestModel);
    }
}
