package requestModel;

import entity.Order;
import java.util.List;

public class PurchaseRequestModel {

    private List<Order> orders;

    public PurchaseRequestModel(List<Order> orders){
        this.orders = orders;
    }

    public List<Order> getOrders(){
        return orders;
    }
}
