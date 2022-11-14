package Wallet_use_case;

public class WalletRequestModel {
    private double balance;

    public WalletRequestModel(double balance) {
        this.balance = balance;
    }

    double getBalance() {
        return balance;
    }

    void setBalance() {
        this.balance = balance;
    }
}
