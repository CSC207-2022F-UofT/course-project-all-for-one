package presenter;

import Wallet_use_case.WalletResponseModel;
import Wallet_use_case.WalletOutputBoundary;

public class WalletResponsePresenter implements WalletOutputBoundary {
    @Override
    public WalletResponseModel prepareWalletView(WalletResponseModel walletResponse){
        return walletResponse;
    }
}
