package controller;

import Wallet_use_case.WalletInputBoundary;
import Wallet_use_case.WalletRequestModel;
import Wallet_use_case.WalletResponseModel;

public class WalletController {
    final WalletInputBoundary walletInput;

    public WalletController(WalletInputBoundary accountGateway){
        this.walletInput = accountGateway;
    }

    public WalletResponseModel create(double balance) {
        WalletRequestModel requestModel = new WalletRequestModel(balance);
        return walletInput.create(requestModel);
    }
}
