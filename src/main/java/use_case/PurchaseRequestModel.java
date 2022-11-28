package use_case;

import entity.Order;
import java.util.List;

public class PurchaseRequestModel {

    private final String username;

    private List<String> creation_times;

    public PurchaseRequestModel(String username, List<String> creation_times){
        this.username = username;
        this.creation_times = creation_times;
    }

    public String getUsername(){
        return username;
    }

    public List<String> getCreationTimes(){
        return creation_times;
    }
}
