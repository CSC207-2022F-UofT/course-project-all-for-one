package use_case;

public interface PostPresenter {
    PostResponseModel prepareSuccessView(PostResponseModel post);

    PostResponseModel prepareFailView(String error);
}