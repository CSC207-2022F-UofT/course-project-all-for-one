package application_business_rules_layer.userUseCases;

import enterprise_business_rules_layer.Wallet;

public class UserRegisterRequestModel {

    private String username;
    private String password;
    private String repeatedPassword;


    public UserRegisterRequestModel(String username, String password, String repeatedPassword){
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

}
