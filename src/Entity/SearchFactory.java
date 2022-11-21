package Entity;

import java.util.List;

public class SearchFactory {
    public Search create(List<Post> searchResult){
        return new Search(searchResult);
}
