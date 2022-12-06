package enterprise_business_rules_layer.postEntities;

public class Criteria {
    /**
     * Evaluates post against pre-defined criteria
     * If post fails a criteria, suggestion is given to improve it
     * Invoking function can check if the suggestion is empty, then post is strong
     *
     * @param post
     * @return Suggestion
     */
    public Suggestion evaluatePost(Post post) {
        Suggestion suggestion = new Suggestion();

        // Check if post title contains empty spaces
        if (post.getTitle().isBlank()) {
            suggestion.setSuggestion("Title should not be empty");
        }
        // Check if post description contains empty spaces
        else if (post.getDescription().isBlank()) {
            suggestion.setSuggestion("Description should not be empty");
        }
        // Check if post description is greater than or equal to 3 chars
        else if (post.getTitle().length() < 3) {
            suggestion.setSuggestion("Please add more detail for your title");
        }
        // Check if post title is lesser than 80 chars
        else if (post.getTitle().length() > 80) {
            suggestion.setSuggestion("Title is too long, max char is 80");
        }
        // Check if post description is greater than or equal to 3 chars
        else if (post.getDescription().length() < 3) {
            suggestion.setSuggestion("Please add more detail for your description");
        }
        // Check if post description is lesser than 1500 chars
        else if (post.getDescription().length() > 10000) {
            suggestion.setSuggestion("Description too long, max char is 1500");
        }

        return suggestion;
    }
}
