package framworks_drivers_layer.views;

import application_business_rules_layer.postcreateUseCases.PostCreateInputBoundary;
import application_business_rules_layer.postcreateUseCases.PostCreateRequestModel;
import application_business_rules_layer.postcreateUseCases.PostCreateResponseModel;

import java.util.ArrayList;

// Interface adapters layer

public class PostController {

    final PostCreateInputBoundary userInput;

    public PostController(PostCreateInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public PostCreateResponseModel create(String input_username, String input_title, String input_description, double input_price, ArrayList<String> tags) {
        PostCreateRequestModel requestModel = new PostCreateRequestModel(input_username, input_title, input_description, input_price, tags);

        return userInput.create(requestModel);
    }
}
