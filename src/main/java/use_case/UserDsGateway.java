package use_case;

public interface UserDsGateway {
    boolean existsByName(String username);

    boolean isPasswordCorrect (String username, String password);

    void save(UserRegisterDsRequestModel requestModel);


}
