package UI;
import use_case.PostDsGateway;
import gateway.PostDsRequestModel;

import java.util.HashMap;
import java.util.Map;

public class MemoryPost implements PostDsGateway {

    final private Map<String, PostDsRequestModel> posts = new HashMap<>();


    /**
     * @param requestModel the data to save
     */
    @Override
    public void save(PostDsRequestModel requestModel) {
        System.out.println("Save " + requestModel.get_username() + ": " + requestModel.get_title());
        posts.put(requestModel.get_username(), requestModel);
    }
}
