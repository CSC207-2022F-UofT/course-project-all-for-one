package entity;

public class AccountFactory {

    public static Account create(String name, String password, Wallet wallet) {
        return new Account(name, password, wallet);
    }
}