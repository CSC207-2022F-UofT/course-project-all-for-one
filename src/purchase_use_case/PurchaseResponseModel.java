package purchase_use_case;

import entity.Order;
import java.util.List;

public class PurchaseResponseModel {
    List<Order> orders;

    public PurchaseResponseModel(List<Order> orders){
        this.orders = orders;
    }

    public List<Order> getOrders(){
        return orders;
    }

    public void setOrders(){
        this.orders = orders;
    }
}
