package UI;

public class PostCreationFailed extends RuntimeException {
    public PostCreationFailed(String error) {
        super(error);
    }
}
