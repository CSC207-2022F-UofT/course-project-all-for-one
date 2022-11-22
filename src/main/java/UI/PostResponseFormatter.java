package UI;

import use_case.PostPresenter;
import use_case.PostResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface adapters layer

public class PostResponseFormatter implements PostPresenter {

    @Override
    public PostResponseModel prepareSuccessView(PostResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    @Override
    public PostResponseModel prepareFailView(String error) {
        throw new PostCreationFailed(error);
    }
}

