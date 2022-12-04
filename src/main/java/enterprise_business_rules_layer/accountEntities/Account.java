package enterprise_business_rules_layer.accountEntities;

import enterprise_business_rules_layer.Wallet;

public class Account {

    public final String username;
    public final String password;
    public final Wallet wallet;

    Account(String username, String password, Wallet wallet){
        this.username = username;
        this.password = password;
        this.wallet = wallet;
    }

    /**
     *
     * @return the username of the account
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return the password of the account
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return the Wallet Object of the account
     */
    public Wallet getWallet() {
        return this.wallet;
    }
}