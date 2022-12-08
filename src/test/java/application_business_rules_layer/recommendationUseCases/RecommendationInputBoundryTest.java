package application_business_rules_layer.recommendationUseCases;

import Interface_adapters_layer.presenter.RecommendationResponsePresenter;
import application_business_rules_layer.postUseCases.PostDsGateway;
import application_business_rules_layer.postUseCases.PostDsRequestModel;
import framworks_drivers_layer.dataAccess.MemoryPost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.fail;

class RecommendationInputBoundryTest {

    @Test
    void create1() {
        ArrayList<String> purchaseHistoryTags = new ArrayList<>();
        purchaseHistoryTags.add("iphone");purchaseHistoryTags.add("iphone");purchaseHistoryTags.add("iphone");
        purchaseHistoryTags.add("gaming");purchaseHistoryTags.add("gaming");purchaseHistoryTags.add("gaming");purchaseHistoryTags.add("gaming");
        purchaseHistoryTags.add("computer");purchaseHistoryTags.add("computer");purchaseHistoryTags.add("computer");
        purchaseHistoryTags.add("should not shown");

        ArrayList<String> tagsOfPost12 = new ArrayList<>();
        tagsOfPost12.add("iphone");
        tagsOfPost12.add("apple");

        PostDsGateway postDsGateway = new MemoryPost();
        PostDsRequestModel post1 = new PostDsRequestModel(
                "Seller1", "iphone1", "good", "1", tagsOfPost12 , LocalDateTime.now(), "1");

        PostDsRequestModel post2 = new PostDsRequestModel(
                "Seller2", "iphone2", "good", "1", tagsOfPost12 , LocalDateTime.now(), "2");



        postDsGateway.save(post1); postDsGateway.save(post2);
        RecommendationOutputBoundry recommendationOutputBoundry = new RecommendationResponsePresenter(){
            @Override
            public RecommendationResponseModel prepareRecommendationView(RecommendationResponseModel recommendationResponseModel) {

                Assertions.assertEquals(2, recommendationResponseModel.getRecommendation().getPosts().size());
                return null;
            }

            @Override
            public RecommendationResponseModel prepareFailView(String error) {
                System.out.println(error);
                fail("Use case failure is not expected.");
                return null;
            }
        };



        RecommendationRequestModel recommendationRequestModel = new RecommendationRequestModel(purchaseHistoryTags, "Nuan Wen");
        RecommendationInputBoundry recommendationInputBoundry = new RecommendationInteractor(recommendationOutputBoundry, postDsGateway);
        recommendationInputBoundry.create(recommendationRequestModel);
    }

    @Test
    void create2(){
        ArrayList<String> purchaseHistoryTags = new ArrayList<>();
        purchaseHistoryTags.add("iphone");purchaseHistoryTags.add("iphone");purchaseHistoryTags.add("iphone");
        purchaseHistoryTags.add("gaming");purchaseHistoryTags.add("gaming");purchaseHistoryTags.add("gaming");purchaseHistoryTags.add("gaming");
        purchaseHistoryTags.add("computer");purchaseHistoryTags.add("computer");purchaseHistoryTags.add("computer");
        purchaseHistoryTags.add("should not shown");

        ArrayList<String> tagsOfPost12 = new ArrayList<>();
        tagsOfPost12.add("macbook");
        tagsOfPost12.add("apple");

        PostDsGateway postDsGateway = new MemoryPost();
        PostDsRequestModel post1 = new PostDsRequestModel(
                "Seller1", "macbook1", "good", "1", tagsOfPost12 , LocalDateTime.now(), "1");

        PostDsRequestModel post2 = new PostDsRequestModel(
                "Seller2", "macbook2", "good", "1", tagsOfPost12 , LocalDateTime.now(), "2");
        postDsGateway.save(post1); postDsGateway.save(post2);

        RecommendationOutputBoundry recommendationOutputBoundry = new RecommendationResponsePresenter(){
            @Override
            public RecommendationResponseModel prepareRecommendationView(RecommendationResponseModel recommendationResponseModel) {

                fail("Use case success is not expected");
                return null;
            }

            @Override
            public RecommendationResponseModel prepareFailView(String error) {
                Assertions.assertEquals(error, "There is no recommendation for you now!");
                return null;
            }
        };



        RecommendationRequestModel recommendationRequestModel = new RecommendationRequestModel(purchaseHistoryTags, "Nuan Wen");
        RecommendationInputBoundry recommendationInputBoundry = new RecommendationInteractor(recommendationOutputBoundry, postDsGateway);
        recommendationInputBoundry.create(recommendationRequestModel);
    }

    @Test
    void create3(){
        ArrayList<String> purchaseHistoryTags = new ArrayList<>();
        purchaseHistoryTags.add("iphone");purchaseHistoryTags.add("iphone");purchaseHistoryTags.add("iphone");
        purchaseHistoryTags.add("gaming");purchaseHistoryTags.add("gaming");purchaseHistoryTags.add("gaming");purchaseHistoryTags.add("gaming");

        ArrayList<String> tagsOfPost12 = new ArrayList<>();
        tagsOfPost12.add("macbook");
        tagsOfPost12.add("apple");

        PostDsGateway postDsGateway = new MemoryPost();
        PostDsRequestModel post1 = new PostDsRequestModel(
                "Seller1", "macbook1", "good", "1", tagsOfPost12 , LocalDateTime.now(), "1");

        PostDsRequestModel post2 = new PostDsRequestModel(
                "Seller2", "macbook2", "good", "1", tagsOfPost12 , LocalDateTime.now(), "2");
        postDsGateway.save(post1); postDsGateway.save(post2);

        RecommendationOutputBoundry recommendationOutputBoundry = new RecommendationResponsePresenter(){
            @Override
            public RecommendationResponseModel prepareRecommendationView(RecommendationResponseModel recommendationResponseModel) {

                fail("Use case success is not expected");
                return null;
            }

            @Override
            public RecommendationResponseModel prepareFailView(String error) {
                Assertions.assertEquals(error, "Please use more to have recommendation!");
                return null;
            }
        };



        RecommendationRequestModel recommendationRequestModel = new RecommendationRequestModel(purchaseHistoryTags, "Nuan Wen");
        RecommendationInputBoundry recommendationInputBoundry = new RecommendationInteractor(recommendationOutputBoundry, postDsGateway);
        recommendationInputBoundry.create(recommendationRequestModel);
    }
}