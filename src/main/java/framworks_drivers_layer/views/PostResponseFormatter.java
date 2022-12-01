package framworks_drivers_layer.views;

import application_business_rules_layer.postcreateUseCases.PostCreateOutputBoundary;
import application_business_rules_layer.postcreateUseCases.PostCreateResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface adapters layer

public class PostResponseFormatter implements PostCreateOutputBoundary {

    @Override
    public PostCreateResponseModel prepareSuccessView(PostCreateResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    @Override
    public PostCreateResponseModel prepareFailView(String error) {
        throw new PostCreationFailed(error);
    }
}

