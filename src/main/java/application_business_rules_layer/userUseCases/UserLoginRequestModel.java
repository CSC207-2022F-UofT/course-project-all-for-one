package application_business_rules_layer.userUseCases;

public class UserLoginRequestModel {

    private final String username;
    private final String password;


    public UserLoginRequestModel(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return the username to be processed by the use case
     */
    public String getUsername(){
        return username;
    }

    /**
     *
     * @return the password to be processed by the use case
     */
    public String getPassword(){
        return password;
    }


}
