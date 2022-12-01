package application_business_rules_layer.postdeleteUseCases;
import application_business_rules_layer.postcreateUseCases.PostCreateDsRequestModel;
import enterprise_business_rules_layer.postEntities.Post;


public interface PostDeleteDsGateway {
    void delete(PostCreateDsRequestModel requestModel);
}