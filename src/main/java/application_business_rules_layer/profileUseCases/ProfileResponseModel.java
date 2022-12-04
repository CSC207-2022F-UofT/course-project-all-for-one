package application_business_rules_layer.profileUseCases;

import enterprise_business_rules_layer.Profile;

public class ProfileResponseModel {
    String age;
    String username;

    String gender;
    String description;
    String address;
    String phone;

    public ProfileResponseModel(String username, String age, String gender, String description, String address, String phone){
        this.age = age;
        this.username = username;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
    }

    public Profile create(){
        return new Profile(this.username, this.age, this.gender, this.description, this.address,this.phone);
    }

}
