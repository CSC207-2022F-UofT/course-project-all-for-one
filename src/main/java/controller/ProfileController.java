package main.java.controller;

import main.java.use_case.ProfileInputBoundary;
import main.java.use_case.ProfileRequestModel;
import main.java.use_case.ProfileResponseModel;

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
