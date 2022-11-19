package useCases;

import java.time.LocalDateTime;


public class LoginDsRequestModel {
    private final String name;
    private String password;
    private final LocalDateTime lastAccessTime;

    public LoginDsRequestModel(String name, String password, LocalDateTime lastAccessTime) {
        this.name = name;
        this.password = password;
        this.lastAccessTime = lastAccessTime;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

}
