package application_business_rules_layer.userUseCases;

import enterprise_business_rules_layer.Wallet;

public class UserLoginRequestModel {

    private String username;
    private String password;

    private Wallet wallet;

    public UserLoginRequestModel(String username, String password, Wallet wallet){
        this.username = username;
        this.password = password;
        this.wallet = wallet;
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

    public Wallet getWallet() {
        return this.wallet;
    }
}
