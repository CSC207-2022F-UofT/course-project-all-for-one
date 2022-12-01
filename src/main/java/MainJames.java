import Interface_adapters_layer.controller.RecommendationController;
import Interface_adapters_layer.presenter.RecommendationResponsePresenter;
import application_business_rules_layer.postcreateUseCases.PostCreateDsGateway;
import application_business_rules_layer.recommendationUseCases.RecommendationInputBoundry;
import application_business_rules_layer.recommendationUseCases.RecommendationInteractor;
import application_business_rules_layer.recommendationUseCases.RecommendationOutputBoundry;
import application_business_rules_layer.tradeUseCases.OrderDsGateway;
import framworks_drivers_layer.dataAccess.FileOrder;
import framworks_drivers_layer.dataAccess.FilePost;
import framworks_drivers_layer.views.MainPage;

import javax.swing.*;
import java.io.IOException;

public class MainJames {
    public static void main(String[] args) {
        //jFrame setup


//        ArrayList<String> tags = new ArrayList<>();
//        tags.add(0, "xxx");
//        //assign functions to recommendationButton
//
//        List<Post> posts = new ArrayList<>();
//        Post post1 = new Post("sadf","iphone13", "good",  1300, tags);
//        Post post2 = new Post("aswefwe","ipad pro", "take notes",  999, tags);
//        Post post3 = new Post("sfdgz","airpods", "good sounding", 230, tags);
//        posts.add(post1);
//        posts.add(post2);
//        posts.add(post3);

        JFrame jf = new JFrame("main");
        jf.setBounds(400, 300, 600, 300);
        String username = "Nuan Wen";
        RecommendationOutputBoundry recommendationOutputBoundry = new RecommendationResponsePresenter();
        PostCreateDsGateway post;
        try {
            post = new FilePost("./posts.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create posts.csv.");
        }
        RecommendationInputBoundry recommendationInputBoundry = new RecommendationInteractor(recommendationOutputBoundry, post);
        OrderDsGateway orderDsGateway;
        try{
            orderDsGateway = new FileOrder("./orders.csv");
        } catch (IOException e){
            throw new RuntimeException("Could not create orders.csv");
        }
        RecommendationController recommendationController = new RecommendationController(username, recommendationInputBoundry, orderDsGateway);
        MainPage mainPage = new MainPage(username, recommendationController);

        jf.add(mainPage);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
