package Interface_adapters_layer.presenter;

import application_business_rules_layer.postUseCases.PostOutputBoundary;
import application_business_rules_layer.postUseCases.PostResponseModel;
import framworks_drivers_layer.views.PostCreationFailed;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface adapters layer

public class PostResponsePresenter implements PostOutputBoundary {
    /**
     *
     * @param response the input that needs processing
     * @return return a PostResponseModel object if there is no error
     */
    @Override
    public PostResponseModel prepareSuccessView(PostResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    /**
     *
     * @param error String that describe the error type
     * @return the error
     */
    @Override
    public PostResponseModel prepareFailView(String error) {
        throw new PostCreationFailed(error);
    }
}

