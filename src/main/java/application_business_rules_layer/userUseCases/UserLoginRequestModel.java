package application_business_rules_layer.userUseCases;

import enterprise_business_rules_layer.Wallet;

public class UserLoginRequestModel {

    private String username;
    private String password;


    public UserLoginRequestModel(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
