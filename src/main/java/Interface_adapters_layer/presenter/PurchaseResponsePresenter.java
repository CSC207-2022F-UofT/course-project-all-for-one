package Interface_adapters_layer.presenter;

import enterprise_business_rules_layer.orderEntities.PhysicalOrder;
import java.util.List;

public class PurchaseResponsePresenter {
    public List<PhysicalOrder> createPurchaseHistoryPage(List<PhysicalOrder> physicalOrders){
        return physicalOrders;
    }
}
