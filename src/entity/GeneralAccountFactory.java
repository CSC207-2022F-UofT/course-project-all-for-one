package entity;

public class GeneralAccountFactory implements AccountFactory{
    @Override
    public Account create(String name, String password, Wallet wallet) {
        return new GeneralAccount(name, password, wallet);
    }
}