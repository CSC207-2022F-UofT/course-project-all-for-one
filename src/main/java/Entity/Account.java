package Entity;

public class Account {

    public final String username;
    public final String password;

    public boolean loginStatus;

    public final Wallet Wallet;

    Account(String username, String password, Wallet wallet){
        this.username = username;
        this.password = password;
        this.Wallet = wallet;
    }
    //TODO implement valid password criteria

    public boolean passwordIsValid() {
        return false;
    }


    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }


    public boolean getLoginStatus() {
        return loginStatus;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public Wallet getWallet() {
        return this.Wallet;
    }
}