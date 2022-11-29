package enterprise_business_rules_layer;

public class Wallet {
    double balance;

    public Wallet(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }

    public void addBalance(double transactionAmount){
        balance += transactionAmount;
    }

    public void subtractBalance(double transactionAmount){
        balance -= transactionAmount;
    }
}
