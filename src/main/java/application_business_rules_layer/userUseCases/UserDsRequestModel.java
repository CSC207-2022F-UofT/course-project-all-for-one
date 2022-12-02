package application_business_rules_layer.userUseCases;

import java.time.LocalDateTime;

public class UserDsRequestModel {

    private final String name;
    private String password;
    private final LocalDateTime creationTime;

    private double walletBalance;

    public UserDsRequestModel(String name, String password, LocalDateTime creationTime, double walletBalance) {
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

    public double getWalletBalance() {
        return this.walletBalance;
    }

    public void setWalletBalance(double newBalance) {
        this.walletBalance = newBalance;
    }


}
