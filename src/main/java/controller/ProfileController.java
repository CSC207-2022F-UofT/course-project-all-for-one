package main.java.controller;

import use_case.ProfileInputBoundary;
import use_case.ProfileRequestModel;
import use_case.ProfileResponseModel;

public class ProfileController  {
    final ProfileInputBoundary userinput;


    public ProfileController(ProfileInputBoundary userinput ) {
        this.userinput = userinput;
    }

    ProfileResponseModel create(int age, String address, String username, String description, String phone){
        ProfileRequestModel requestModel = new ProfileRequestModel(age, address , username, description, phone);
        //return userinput.create(requestModel);
         return null;
    }

}
