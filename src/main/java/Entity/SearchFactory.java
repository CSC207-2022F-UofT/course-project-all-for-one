package Entity;

import java.util.List;

public class SearchFactory {
    public static Search create(List<Post> searchResult) {
        return new Search(searchResult);
    }
}
