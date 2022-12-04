package framworks_drivers_layer.views;

import application_business_rules_layer.postUseCases.PostInputBoundary;
import application_business_rules_layer.postUseCases.PostRequestModel;
import application_business_rules_layer.postUseCases.PostResponseModel;

import java.util.ArrayList;

// Interface adapters layer

public class PostController {

    final PostInputBoundary userInput;

    public PostController(PostInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public PostResponseModel create(String input_username, String input_title, String input_description, double input_price, ArrayList<String> tags) {
        PostRequestModel requestModel = new PostRequestModel(input_username, input_title, input_description, input_price, tags);

        return userInput.create(requestModel);
    }
}
