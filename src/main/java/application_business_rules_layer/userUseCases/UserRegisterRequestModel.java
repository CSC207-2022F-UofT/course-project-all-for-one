package application_business_rules_layer.userUseCases;

import enterprise_business_rules_layer.Wallet;

public class UserRegisterRequestModel {

    private final String username;
    private final String password;
    private final String repeatedPassword;


    public UserRegisterRequestModel(String username, String password, String repeatedPassword){
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }

    /**
     *
     * @return the username to be processed by the use case
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return the password to be processed by the use case
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return the repeated password to be processed by the use case
     */
    public String getRepeatedPassword() {
        return repeatedPassword;
    }


}
