package entity;

public class GeneralAccount implements Account{

    public final String username;
    public final String password;

    public boolean loginStatus;

    public final Wallet Wallet;

    GeneralAccount(String username, String password, Wallet wallet){
        this.username = username;
        this.password = password;
        this.Wallet = wallet;
    }
    //TODO implement valid password criteria
    @Override
    public boolean passwordIsValid() {
        return false;
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

    @Override
    public Wallet getWallet() {
        return this.Wallet;
    }
}