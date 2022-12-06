package enterprise_business_rules_layer.accountEntities;

import enterprise_business_rules_layer.Wallet;
import enterprise_business_rules_layer.accountEntities.Account;

public class AccountFactory {

    /**
     *
     * @param name the username of the Account object to create
     * @param password the password of the Account object to create
     * @param wallet the Wallet object of the Account object to create
     * @return Account object
     */
    public Account create(String name, String password, Wallet wallet) {
        return new Account(name, password, wallet);
    }
}