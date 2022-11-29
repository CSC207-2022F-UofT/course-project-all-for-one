package enterprise_business_rules_layer.accountEntities;

import enterprise_business_rules_layer.Wallet;

public class Account {

    public final String username;
    public final String password;

    public boolean loginStatus;

    public final enterprise_business_rules_layer.Wallet Wallet;

    Account(String username, String password, Wallet wallet){
        this.username = username;
        this.password = password;
        this.Wallet = wallet;
    }


    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }


    public boolean getLoginStatus() {
        return loginStatus;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public Wallet getWallet() {
        return this.Wallet;
    }
}