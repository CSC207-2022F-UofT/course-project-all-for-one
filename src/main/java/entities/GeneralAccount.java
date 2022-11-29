package entities;

public class GeneralAccount implements Account{

    private final String username;
    private final String password;

    private boolean loginStatus;

    GeneralAccount(String username, String password){
        this.username = username;
        this.password = password;
    }
    //TODO improve valid password criteria
    @Override
    public boolean passwordIsValid() {
        return this.password.matches("[0-9a-zA-Z_\\-+=*&^%$#@!]{8,}");
    }

    @Override
    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public boolean getLoginStatus() {
        return loginStatus;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
