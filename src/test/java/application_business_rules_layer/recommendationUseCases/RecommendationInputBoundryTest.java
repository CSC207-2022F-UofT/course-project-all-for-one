//package application_business_rules_layer.recommendationUseCases;
//
//import Interface_adapters_layer.presenter.RecommendationResponsePresenter;
//import application_business_rules_layer.postUseCases.PostDsGateway;
//import application_business_rules_layer.postUseCases.PostDsRequestModel;
//import framworks_drivers_layer.dataAccess.MemoryPost;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.fail;
//
//class RecommendationInputBoundryTest {
//
//    @Test
//    void create() {
//        PostDsGateway postDsGateway = new MemoryPost();
//        PostDsRequestModel post1 = new PostDsRequestModel("a")
//        postDsGateway.save();
//        RecommendationOutputBoundry recommendationOutputBoundry = new RecommendationResponsePresenter(){
//            @Override
//            public RecommendationResponseModel prepareRecommendationView(RecommendationResponseModel recommendationResponseModel) {
//
//                assertEquals("paul", recommendationResponseModel);
//                assertNotNull(user.getCreationTime()); // any creation time is fine.
//                assertTrue(userRepository.existsByName("paul"));
//                return null;
//            }
//
//            @Override
//            public UserRegisterResponseModel prepareFailView(String error) {
//                fail("Use case failure is unexpected.");
//                return null;
//            }
//        };
//
//
//        List<String> tags = new ArrayList<>();
//        tags.add("iphone");tags.add("iphone");tags.add("iphone");
//        tags.add("gaming");tags.add("gaming");tags.add("gaming");tags.add("gaming");
//        tags.add("computer");tags.add("computer");tags.add("computer");
//        tags.add("should not be added");
//        RecommendationRequestModel recommendationRequestModel = new RecommendationRequestModel(tags, "Nuan Wen");
//        RecommendationInputBoundry recommendationInputBoundry = new RecommendationInteractor(recommendationOutputBoundry, postDsGateway);
//        recommendationInputBoundry.create(recommendationRequestModel);
//    }
//}