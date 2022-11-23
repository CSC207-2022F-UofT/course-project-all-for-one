package use_case;

import gateway.PostDsRequestModel;

public interface PostDsGateway {
    void save(PostDsRequestModel requestModel);
}
