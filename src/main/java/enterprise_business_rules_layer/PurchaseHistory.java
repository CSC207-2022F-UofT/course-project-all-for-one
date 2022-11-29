package enterprise_business_rules_layer;

import enterprise_business_rules_layer.orderEntities.PhysicalOrder;

import java.util.List;

public class PurchaseHistory {
    private List<PhysicalOrder> physicalOrders;

    public PurchaseHistory(List<PhysicalOrder> physicalOrders) {
        this.physicalOrders = physicalOrders;
    }

    public List<PhysicalOrder> getOrders(){
        return physicalOrders;
    }
}