package entity;

import java.util.List;

public class PurchaseHistory {
    private List<Order> orders;
    PurchaseHistory(List<Order> orders){
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
