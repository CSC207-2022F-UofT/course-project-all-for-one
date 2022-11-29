package Interface_adapters_layer.controller;

import application_business_rules_layer.profileUseCases.ProfileInputBoundary;
import application_business_rules_layer.profileUseCases.ProfileRequestModel;
import application_business_rules_layer.profileUseCases.ProfileResponseModel;

public class ProfileController {
    static ProfileInputBoundary userinput;

    public ProfileController(ProfileInputBoundary UserDsGateway){
        this.userinput = UserDsGateway;
    }

    public static ProfileResponseModel create(int age, String username, String address, String description, String phone)
    {
        ProfileRequestModel requestModel = new ProfileRequestModel(age,address,username,description,phone);
        return userinput.create(requestModel);
    }
}
