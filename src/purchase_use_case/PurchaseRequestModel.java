package purchase_use_case;

import entity.Order;
import java.util.List;

public class PurchaseRequestModel {
    private List<Order> orders;

    public PurchaseRequestModel(List<Order> orders){
        this.orders = orders;
    }

    List<Order> getOrders(){
        return orders;
    }

    void setOrders(){
        this.orders = orders;
    }
}
