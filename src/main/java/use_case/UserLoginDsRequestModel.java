package use_case;

import java.time.LocalDateTime;


public class UserLoginDsRequestModel {
    private final String name;
    private String password;

    public UserLoginDsRequestModel(String name, String password) {
        this.name = name;
        this.password = password;
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

}
