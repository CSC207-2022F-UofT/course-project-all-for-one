package main.java.use_case;

public class ProfileResponseModel {
    String age;
    String username;
    String description;
    String address;
    String phone;

    public ProfileResponseModel(String age, String username, String description, String address, String phone){
        this.age = age;
        this.username = username;
        this.description = description;
        this.address = address;
        this.phone = phone;
    }

}
