package presenter;

import Wallet_use_case.WalletResponseModel;
import Wallet_use_case.WalletOutputBoundary;

public class WalletResponsePresenter implements WalletOutputBoundary {
    @Override
    public WalletResponseModel prepareSuccessView(WalletResponseModel walletResponse){
        return walletResponse;
    }

    @Override
    public WalletResponseModel prepareFailView(String error){
        return error;
    }
}
