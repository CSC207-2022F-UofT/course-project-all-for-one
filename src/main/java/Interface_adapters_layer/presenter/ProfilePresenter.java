package Interface_adapters_layer.presenter;

import enterprise_business_rules_layer.Profile;

import javax.swing.*;
import java.awt.*;

public class ProfilePresenter {
    final String username;
    private String age;
    private String gender;
    private String description;
    private String address;
    private String phone;
    public ProfilePresenter(String username, String age, String gender, String description, String address, String phone){
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.address = address;
        this.phone = phone;
    }


}
