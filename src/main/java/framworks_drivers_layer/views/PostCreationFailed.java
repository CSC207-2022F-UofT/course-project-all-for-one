package framworks_drivers_layer.views;

public class PostCreationFailed extends RuntimeException {

    /**
     *
     * @param error a String that is used to create an Error object
     */
    public PostCreationFailed(String error) {
        super(error);
    }
}
