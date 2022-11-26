package gateway;

import entity.Wallet;
import use_case.WalletRequestModel;

public interface WalletGateway {
    double getBalance(String username);

    void save(WalletRequestModel requestModel);
}
