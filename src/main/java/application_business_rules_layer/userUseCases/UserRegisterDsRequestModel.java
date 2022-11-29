package application_business_rules_layer.userUseCases;

import enterprise_business_rules_layer.Wallet;

import java.time.LocalDateTime;

public class UserRegisterDsRequestModel {

    private final String name;
    private String password;
    private final LocalDateTime creationTime;

    private String walletBalance;

    public UserRegisterDsRequestModel(String name, String password, LocalDateTime creationTime, String walletBalance) {
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
        this.walletBalance = walletBalance;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getWalletBalance() {
        return this.walletBalance;
    }


}
