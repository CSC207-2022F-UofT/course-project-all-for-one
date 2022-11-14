package entities;

public class GeneralAccountFactory implements AccountFactory{
    @Override
    public Account create(String name, String password) {
        return new GeneralAccount(name, password);
    }
}
