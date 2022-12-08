package application_business_rules_layer;

import application_business_rules_layer.postUseCases.*;
import enterprise_business_rules_layer.postEntities.PostFactory;
import framworks_drivers_layer.dataAccess.MemoryPost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

class PostInteracterTest {

    @Test
    void create() {
        // To test the use case:
        // 1) Create a UserRegisterInteractor and prerequisite objects
        //    (arguments for the UserRegisterInteractor constructor parameters)
        // 2) create the Input Data
        // 3) Call the use case User Input Boundary method to run the use case
        // 4) Check that the Output Data passed to the Presenter is correct
        // 5) Check that the expected changes to the data layer are there.

        // 1) UserRegisterInteractor and prerequisite objects
        // We're going to need a place to save and look up information. We could
        // use FileUser, but because unit tests are supposed to be independent
        // that would make us also reset the file when we are done.
        // Instead, we're going to "mock" that info using a short-lived solution
        // that just keeps the info in a dictionary, and it won't be persistent.
        // (Separately, elsewhere, we will need to test the FileUser works
        // properly.)
        PostDsGateway postDsGateway = new MemoryPost();

        // This creates an anonymous implementing class for the Output Boundary.
        PostOutputBoundary postOutputBoundary = new PostOutputBoundary() {
            @Override
            public PostResponseModel prepareSuccessView(PostResponseModel postResponseModel) {
                // 4) Check that the Output Data and associated changes
                // are correct

                Assertions.assertEquals("kevin", postResponseModel.getPost().getUsername());
                Assertions.assertEquals("iphone", postResponseModel.getPost().getUsername());
                Assertions.assertEquals("brand new", postResponseModel.getPost().getDescription());
                Assertions.assertEquals("100", postResponseModel.getPost().getPrice());
                List<String> categories = asList("apple");
                Assertions.assertEquals(postResponseModel.getPost().getTags(), categories);
                Assertions.assertNotNull(postResponseModel.getCreationTime()); // any creation time is fine.
                return null;
            }

            @Override
            public PostResponseModel prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected.");
                return null;
            }
        };

        PostFactory postFactory = new PostFactory();
        PostInputBoundary interactor = new PostInteractor(
                postDsGateway, postOutputBoundary, postFactory);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        ArrayList<String> tags = new ArrayList<String>();
        tags.add("apple");
        PostRequestModel inputData = new PostRequestModel(
                "kevin", "iphone", "brand new", "100", tags);

        // 3) Run the use case
        interactor.create(inputData);
    }
}
