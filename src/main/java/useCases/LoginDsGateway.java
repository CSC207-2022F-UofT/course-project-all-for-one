package useCases;

public interface LoginDsGateway {
    boolean isExistedName(String username);

    boolean isPasswordCorrect (String username, String password);
}
