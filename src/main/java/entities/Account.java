package entities;

public interface Account {

    boolean passwordIsValid();

    void setLoginStatus(boolean loginStatus);

    boolean getLoginStatus();

    String getUsername();

    String getPassword();
}
