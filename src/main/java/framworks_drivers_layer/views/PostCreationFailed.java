package framworks_drivers_layer.views;

public class PostCreationFailed extends RuntimeException {
    public PostCreationFailed(String error) {
        super(error);
    }
}
