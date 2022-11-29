package Interface_adapters_layer.controller;

import application_business_rules_layer.walletUseCases.WalletGateway;

public class WalletController {

    WalletGateway walletGateway;
    public WalletController(String username, WalletGateway walletGateway){
        this.walletGateway=walletGateway;
    }

    public double useGateway(String username) {
        return walletGateway.getBalance(username);
    }

//    public void ac(String a){
//        System.out.println("Click");
//
//        WalletGateway walletGateway= new SystemGateway();
//        WalletController walletController = new WalletController("username", walletGateway);
//        WalletResponsePresenter walletResponsePresenter = new WalletResponsePresenter();
//
//        double balance = walletController.useGateway("username");

//        walletResponsePresenter.createBalancePage(balance); //value should be presented
//    }
}
