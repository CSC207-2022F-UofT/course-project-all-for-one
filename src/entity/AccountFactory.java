package entity;

public interface AccountFactory {
    static Account create(String name, String password, Wallet wallet) {
        return null;
    }

    Account create(String name, String password, Wallet wallet);
}