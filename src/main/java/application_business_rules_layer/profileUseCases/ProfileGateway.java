package application_business_rules_layer.profileUseCases;

import application_business_rules_layer.userUseCases.UserDsRequestModel;

public interface ProfileGateway {

    String getUsername(String username);
    String getAge (String username);

    String getGender (String username);

    String getDescription (String username);

    String getAddress (String username);

    String getPhone (String username);
    void save(ProfileRequestModel requestModel);

    void changeAge (String username, String age);

    void changeGender (String username, String Gender);

    void changeDescription (String username, String description);

    void changePhone (String username, String phone);

    void changeAddress (String username, String address);

}
