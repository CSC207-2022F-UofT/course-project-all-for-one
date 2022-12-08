package Interface_adapters_layer.presenter;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import enterprise_business_rules_layer.postEntities.Post;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SearchFormatterOutputBoundaryTest {
    /**
     * Method under test: {@link SearchFormatterOutputBoundary#prepareSuccessSearchView(List)}
     */
    @Test
    public void testPrepareSuccessSearchView() {
        SearchFormatterOutputBoundary searchFormatterOutputBoundary = new SearchFormatterOutputBoundary();
        ArrayList<Post> postList = new ArrayList<>();
        List<Post> actualPrepareSuccessSearchViewResult = searchFormatterOutputBoundary.prepareSuccessSearchView(postList);
        assertSame(postList, actualPrepareSuccessSearchViewResult);
        assertTrue(actualPrepareSuccessSearchViewResult.isEmpty());
    }

    /**
     * Method under test: {@link SearchFormatterOutputBoundary#prepareFailureSearchView(String)}
     */
    @Test
    public void testPrepareFailureSearchView() {
        assertThrows(SearchFailureError.class,
                () -> (new SearchFormatterOutputBoundary()).prepareFailureSearchView("An error occurred"));
    }
}

