package application_business_rules_layer.postUseCases;

import enterprise_business_rules_layer.postEntities.Criteria;
import enterprise_business_rules_layer.postEntities.Post;
import enterprise_business_rules_layer.postEntities.PostFactory;

import java.time.LocalDateTime;

// Use case layer

public class PostInteractor implements PostInputBoundary {

    final PostDsGateway postDsGateway;
    final PostOutputBoundary postOutputBoundary;
    final PostFactory postFactory;

    /**
     *
     * @param postOutputBoundary relay to Interface_adapters.presenter
     * @param postDfGateway Interface_adapters.gateway to reach post file
     * @param postFactory a factory in entity to create an instance of post
     */
    public PostInteractor(PostDsGateway postDfGateway, PostOutputBoundary postOutputBoundary,
                          PostFactory postFactory) {
        this.postDsGateway = postDfGateway;
        this.postOutputBoundary = postOutputBoundary;
        this.postFactory = postFactory;
    }

    /**
     *
     * @param requestModel the PostRequestModel that serves as the input needed processing the post creation
     * @return the PostResponseModel that shows a result of the creation: preparing a success/failure view
     */
    @Override
    public PostResponseModel create(PostRequestModel requestModel) {

        Post post = postFactory.create(requestModel.get_username(), requestModel.get_title(), requestModel.get_description(), requestModel.get_price(), requestModel.get_tags());
        Criteria criteria = new Criteria();
        if (!post.is_valid()) {
            return postOutputBoundary.prepareFailView(criteria.evaluatePost(post).getSuggestion());
        }

        LocalDateTime now = LocalDateTime.now();
        PostDsRequestModel postDsModel = new PostDsRequestModel(post.getUsername(), post.getTitle(), post.getDescription(), post.getPrice(), post.getTags(), now, post.getId());
        postDsGateway.save(postDsModel);

        PostResponseModel accountResponseModel = new PostResponseModel(post, now.toString());
        return postOutputBoundary.prepareSuccessView(accountResponseModel);
    }


}
