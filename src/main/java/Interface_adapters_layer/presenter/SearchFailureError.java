package Interface_adapters_layer.presenter;

public class SearchFailureError extends RuntimeException{

    public SearchFailureError(String error) {
        super(error);
    }
}
