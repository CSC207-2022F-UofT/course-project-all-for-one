package application_business_rules_layer.userUseCases;

import java.time.LocalDateTime;

public class UserDsRequestModel {

    private final String name;
    private final String password;
    private final LocalDateTime creationTime;

    private double walletBalance;

    public UserDsRequestModel(String name, String password, LocalDateTime creationTime, double walletBalance) {
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
        this.walletBalance = walletBalance;
    }

    /**
     *
     * @return the username of the user to be saved in database
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the password of the user to be saved in database
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return the creation time of the user to be saved in database
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @return the balance of the user to be saved in database
     */
    public double getWalletBalance() {
        return this.walletBalance;
    }

    /**
     *
     * @param newBalance the new balance wanted to be saved in database
     */
    public void setWalletBalance(double newBalance) {
        this.walletBalance = newBalance;
    }


}
