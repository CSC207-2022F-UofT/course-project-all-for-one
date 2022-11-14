package Wallet_use_case;

import entity.Wallet;

public class WalletBalanceInteractor implements WalletInputBoundary {

    final WalletGateway walletGateway;
    final WalletResponsePresenter walletPresenter;
    final Wallet wallet;

    public WalletBalanceInteractor(WalletGateway walletGateway1, WalletResponsePresenter walletResponsePresenter,
                                   Wallet wallet1){
        this.walletGateway = walletGateway1;
        this.walletPresenter = walletResponsePresenter;
        this.wallet = wallet1;
    }

    @Override
    public WalletResponseModel create(WalletRequestModel requestModel){

    }




}
