package presenter;

public class RecommendationFailedError extends RuntimeException{
    /**
     *
     * @param error a String that is used to create an Error object
     */
    public RecommendationFailedError(String error) {super(error);}
}
