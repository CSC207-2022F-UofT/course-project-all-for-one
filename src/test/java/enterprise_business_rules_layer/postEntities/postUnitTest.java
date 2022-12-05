package enterprise_business_rules_layer.postEntities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class postUnitTest {
    @Test
    void givenEmptyTitle_whenTitleIsNotValid_thenIsFalse() {
        ArrayList<String> lst = new ArrayList<>();
        lst.add("123");
        Criteria criteria = new Criteria();
        Post post = new Post("Kevin", "", "123456", 90, lst);
        assertTrue(criteria.evaluatePost(post).getSuggestion().equals("Title should not be empty"));
    }

    @Test
    void givenEmptyDescription_whenTitleIsNotValid_thenIsFalse() {
        ArrayList<String> lst = new ArrayList<>();
        lst.add("123");
        Criteria criteria = new Criteria();
        Post post = new Post("Kevin", "Hello", "", 90, lst);
        assertTrue(criteria.evaluatePost(post).getSuggestion().equals("Title should not be empty"));
    }
}
