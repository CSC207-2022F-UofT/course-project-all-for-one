package framworks_drivers_layer.dataAccess;

import application_business_rules_layer.profileUseCases.ProfileGateway;
import application_business_rules_layer.profileUseCases.ProfileRequestModel;

import java.util.HashMap;
import java.util.Map;

public class MemoryProfile implements ProfileGateway {
    final private Map<String, ProfileRequestModel> profile = new HashMap<>();

    @Override
    public String getUsername(String username) {
        return profile.get(username).getUsername();
    }

    @Override
    public String getAge(String username) {
        return profile.get(username).getAge();
    }

    @Override
    public String getGender(String username) {
        return profile.get(username).getGender();
    }

    @Override
    public String getDescription(String username) {
        return profile.get(username).getDescription();
    }

    @Override
    public String getAddress(String username) {
        return profile.get(username).getAddress();
    }

    @Override
    public String getPhone(String username) {
        return profile.get(username).getPhone();
    }

    @Override
    public void save(ProfileRequestModel requestModel) {
        System.out.println("Save " + requestModel.getUsername());
        profile.put(requestModel.getUsername(), requestModel);
    }
}
