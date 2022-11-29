package framworks_drivers_layer.views;

public class TradeFailed extends RuntimeException {
    public TradeFailed(String error) {
        super(error);
    }
}
