package application_business_rules_layer.profileUseCases;

import application_business_rules_layer.userUseCases.UserDsRequestModel;

/**
 * A gateway to access the database
 */
public interface ProfileGateway {
    /**
     *
     * @param username
     * @return the username store in database
     */

    String getUsername(String username);

    /**
     *
     * @param username
     * @return the age with corresponding param store in database
     */
    String getAge (String username);

    /**
     *
     * @param username
     * @return the gender with corresponding param username store in database.
     */

    String getGender (String username);

    /**
     *
     * @param username
     * @return the description with corresponding param username store in database.
     */

    String getDescription (String username);

    /**
     *
     * @param username
     * @return the address with corresponding param username store in database
     */

    String getAddress (String username);

    /**
     *
     * @param username
     * @return the phone with corresponding param username store in database
     */

    String getPhone (String username);

    /**
     * save the change of profile in database
     * @param requestModel
     */



    void save(ProfileRequestModel requestModel);


}
