package useCases;

public class LoginResponseModel {
    String login;
    String lastAccessTime;

    public LoginResponseModel(String login, String lastAccessTime) {
        this.login = login;
        this.lastAccessTime = lastAccessTime;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCreationTime() {
        return lastAccessTime;
    }

    public void setCreationTime(String lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

}
