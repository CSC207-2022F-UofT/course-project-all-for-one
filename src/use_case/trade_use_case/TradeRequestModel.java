package trade_use_case;

public class TradeRequestModel {

    private Post post;

    private String address;

    public TradeRequestModel(Post post, String address) {
        this.post = post;
        this.address = address;
    }


}
