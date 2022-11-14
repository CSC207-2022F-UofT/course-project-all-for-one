package entities;

public interface AccountFactory {
    Account create(String name, String password);
}
