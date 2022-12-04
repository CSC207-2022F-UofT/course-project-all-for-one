package framworks_drivers_layer.views;

import application_business_rules_layer.postUseCases.PostOutputBoundary;
import application_business_rules_layer.postUseCases.PostResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface adapters layer

public class PostResponseFormatter implements PostOutputBoundary {

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

