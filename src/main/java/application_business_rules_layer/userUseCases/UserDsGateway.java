package application_business_rules_layer.userUseCases;

public interface UserDsGateway {

    /**
     *
     * @param username the username to check
     * @return if there exists a username in the database
     */
    boolean existsByName(String username);

    /**
     *
     * @param username the username to check
     * @param password the password to check
     * @return if the password match with the password of the username in the database
     */
    boolean isPasswordCorrect (String username, String password);

    /**
     *
     * @param username the username to check
     * @return the password of the username in the database
     */
    String getPassword (String username);

    /**
     *
     * @param username the username to check
     * @return the balance of the username in the database
     */
    double getBalance (String username);

    /**
     *
     * @param requestModel the user data to save
     */
    void save(UserDsRequestModel requestModel);

    /**
     *
     * @param username the username to change
     * @param newBalance the balance to change to
     */
    void changeBalance (String username, double newBalance);


}
