package framworks_drivers_layer.views;

public class UserLoginFailed extends RuntimeException {
    public UserLoginFailed(String error) {
        super(error);
    }
}
