//import UI.MainPage;
//import controller.RecommendationController;
//import gateway.FilePost;
//import gateway.RecommendationGateway;
//import presenter.RecommendationResponsePresenter;
//import gateway.PostDsGateway;
//import use_case.RecommendationInputBoundry;
//import use_case.RecommendationInteractor;
//import use_case.RecommendationOutputBoundry;
//
//import javax.swing.*;
//import java.io.IOException;
//
//public class MainJamesReal {
//    public static void main(String[] args) {
//        JFrame jf = new JFrame("main");
//        jf.setBounds(400, 300, 600, 300);
//
//        RecommendationOutputBoundry recommendationOutputBoundry = new RecommendationResponsePresenter();
//
//        PostDsGateway postDsGateway;
//        try {
//            postDsGateway = new FilePost("./posts.csv");
//        } catch (IOException e) {
//            throw new RuntimeException("Could not create file.");
//        }
//
//
//        RecommendationInputBoundry recommendationInputBoundry = new RecommendationInteractor(recommendationOutputBoundry, postDsGateway);
//        JPanel mainPagePanel = new MainPage("username", new RecommendationController(recommendationInputBoundry, ));
//    }
//}
