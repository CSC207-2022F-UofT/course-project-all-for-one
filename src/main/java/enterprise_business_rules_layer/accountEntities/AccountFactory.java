package enterprise_business_rules_layer.accountEntities;

import enterprise_business_rules_layer.Wallet;
import enterprise_business_rules_layer.accountEntities.Account;

public class AccountFactory {

    public Account create(String name, String password, Wallet wallet) {
        return new Account(name, password, wallet);
    }
}