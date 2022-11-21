package UI;

public class TradeFailed extends RuntimeException {
    public TradeFailed(String error) {
        super(error);
    }
}
