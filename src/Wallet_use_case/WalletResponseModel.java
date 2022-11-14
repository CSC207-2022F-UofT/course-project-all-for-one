package Wallet_use_case;

public class WalletResponseModel {
    double balance;

    public WalletResponseModel(double balance){
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
