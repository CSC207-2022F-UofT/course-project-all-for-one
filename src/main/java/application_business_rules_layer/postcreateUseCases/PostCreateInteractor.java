package application_business_rules_layer.postcreateUseCases;

import enterprise_business_rules_layer.postEntities.Criteria;
import enterprise_business_rules_layer.postEntities.Post;
import enterprise_business_rules_layer.postEntities.PostFactory;

import java.time.LocalDateTime;

// Use case layer

public class PostCreateInteractor implements PostCreateInputBoundary {

    final PostCreateDsGateway postDsGateway;
    final PostCreateOutputBoundary postOutputBoundary;
    final PostFactory postFactory;

    public PostCreateInteractor(PostCreateDsGateway postDfGateway, PostCreateOutputBoundary postOutputBoundary,
                                PostFactory postFactory) {
        this.postDsGateway = postDfGateway;
        this.postOutputBoundary = postOutputBoundary;
        this.postFactory = postFactory;
    }

    @Override
    public PostCreateResponseModel create(PostCreateRequestModel requestModel) {

        Post post = postFactory.create(requestModel.get_username(), requestModel.get_title(), requestModel.get_description(), requestModel.get_price(), requestModel.get_tags());
        Criteria criteria = new Criteria();
        if (!post.is_valid()) {
            return postOutputBoundary.prepareFailView(criteria.evaluatePost(post).getSuggestion());
        }

        LocalDateTime now = LocalDateTime.now();
        PostCreateDsRequestModel postDsModel = new PostCreateDsRequestModel(post.getUsername(), post.getTitle(), post.getDescription(), post.getPrice(), post.getTags(), now);
        postDsGateway.save(postDsModel);

        PostCreateResponseModel accountResponseModel = new PostCreateResponseModel(post.getTitle(), now.toString());
        return postOutputBoundary.prepareSuccessView(accountResponseModel);
    }
}
