package application_business_rules_layer.userUseCases;

import enterprise_business_rules_layer.accountEntities.Account;

public class UserLoginResponseModel {
    Account user;


    public UserLoginResponseModel(Account user) {
        this.user = user;

    }

    public Account getUser() {
        return this.user;
    }





}
