package use_case;

import entity.Criteria;
import entity.Post;
import entity.PostFactory;

import java.time.LocalDateTime;

// Use case layer

public class PostInteractor implements PostInputBoundary {

    final PostDsGateway postDsGateway;
    final PostPresenter postPresenter;
    final PostFactory postFactory;

    public PostInteractor(PostDsGateway postDfGateway, PostPresenter postPresenter,
                                  PostFactory postFactory) {
        this.postDsGateway = postDfGateway;
        this.postPresenter = postPresenter;
        this.postFactory = postFactory;
    }

    @Override
    public PostResponseModel create(PostRequestModel requestModel) {

        Post post = postFactory.create(requestModel.get_username(), requestModel.get_title(), requestModel.get_description(), requestModel.get_price(), requestModel.get_tags());
        Criteria criteria = new Criteria();
        if (!post.is_valid()) {
            return postPresenter.prepareFailView(criteria.evaluatePost(post).getSuggestion());
        }

        LocalDateTime now = LocalDateTime.now();
        PostDsRequestModel postDsModel = new PostDsRequestModel(post.getUsername(), post.getTitle(), post.getDescription(), post.getPrice(), post.getTags(), now);
        postDsGateway.save(postDsModel);

        PostResponseModel accountResponseModel = new PostResponseModel(post.getTitle(), now.toString());
        return postPresenter.prepareSuccessView(accountResponseModel);
    }
}