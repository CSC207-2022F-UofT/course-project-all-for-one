package use_case;

public class WalletRequestModel {

    private String username;
    private double balance;

    public WalletRequestModel(String username, double balance) {
        this.username = username;
        this.balance = balance;
    }

    public String getUsername(){
        return username;
    }

    public double getBalance(){
        return balance;
    }
}
