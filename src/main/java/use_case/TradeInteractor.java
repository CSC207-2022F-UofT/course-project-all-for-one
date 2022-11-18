package use_case;

import entity.Order;
import entity.OrderFactory;
import presenter.TradePresenter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TradeInteractor implements TradeInputBoundry {

    final TradePresenter tradePresenter;
    final OrderFactory orderFactory;




    public TradeInteractor(TradePresenter tradePresenter, OrderFactory orderFactory) {
        this.tradePresenter = tradePresenter;
        this.orderFactory = orderFactory;
    }

    @Override
    public TradeResponseModel create(TradeRequestModel requestModel) {
        if (requestModel.getBuyer().getWallet().getBalance() < requestModel.getPost().get_price()) {
            return tradePresenter.prepareFailView("Insufficient balance.");
        }

        if (Objects.equals(requestModel.getPost().get_status(), "Sold")) {
            return tradePresenter.prepareFailView("Item already sold.");
        }

        requestModel.getBuyer().getWallet().subtractBalance(requestModel.getPost().get_price());

        requestModel.getSeller().getWallet().addBalance(requestModel.getPost().get_price());

        LocalDateTime now = LocalDateTime.now();
        String creationTime = now.format(DateTimeFormatter.ofPattern("hh:mm:ss"));

        Order order = OrderFactory.create(requestModel.getPost(), requestModel.getPost().get_price(),
                creationTime, requestModel.getName(),
                requestModel.getAddress(), requestModel.getPhoneNumber());

        requestModel.getPost().solding_post();

        TradeResponseModel tradeResponseModel = new TradeResponseModel("Order Confirmed", creationTime);
        return tradePresenter.prepareSuccessView(tradeResponseModel);

    }
}
