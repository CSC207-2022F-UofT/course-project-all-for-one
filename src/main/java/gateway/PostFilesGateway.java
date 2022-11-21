package gateway;

import entity.Post;
import use_case.PostDsRequestModel;

import java.io.*;
import java.util.*;

public class PostFilesGateway implements RecommendationGateway{
    private File csvfile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, PostDsRequestModel> posts = new HashMap<>();
    public PostFilesGateway(String filePath) throws IOException{
        this.csvfile = new File(filePath);

        headers.put("username", 0);
        headers.put("title", 1);
        headers.put("description", 2);
        headers.put("status", 3);
        headers.put("price", 4);
        headers.put("tags", 5);



        if(csvfile.length() == 0){
            save();
        } else {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvfile));
            bufferedReader.readLine();

            String row;
            while((row  = bufferedReader.readLine()) != null){
                String[] col = row.split(",");
                String username = String.valueOf(col[headers.get("username")]);
                String title = String.valueOf(col[headers.get("title")]);
                String description = String.valueOf(col[headers.get("description")]);
                String status = String.valueOf(col[headers.get("status")]);
                double price = Double.parseDouble(col[headers.get("price")]);
                String[] tags = {Arrays.toString(col[headers.get("tags")].split(":"))};
                PostDsRequestModel post = new PostDsRequestModel(username, title, description, status, price, tags);
                posts.put(username, post);
            }

            bufferedReader.close();
        }
    }


    public void save(PostDsRequestModel post){
        posts.put(post.getUsername(), post);
    }
    public void save(){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(this.csvfile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

//            for (PostDsRequestModel post : posts.values()) {
//                String tagsString = String.format()
//                String line = String.format("%s,%s,%s,%s,%s,%s",
//                        post.getUsername(), post.getTitle(), post.getDescription(), post.getStatus(), post.getPrice(), post.getTags());
//                writer.write(line);
//                writer.newLine();
//            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param Tags list of tags that are used to find Post object with these tags
     * @param username username of the user that is acting
     * @return return a list of Post objects of length at most 30 that contain at least one tag in Tags
     */
    @Override
    // return 30 posts that contain at least one of tags and is not owned by username
    public List<Post> findPosts(List<String> Tags, String username) {
        return null;
    }

    /**
     *
     * @param username username of the user that is acting
     * @return the purchase history object that is owned by the user with username in database
     */
    @Override
    public PurchaseHistory getPurchaseHistory(String username) {
        return null;
    }

    /**
     *
     * @param username username of the user that is acting
     * @return the browsing history object that is owned by the user with username in database
     */
    @Override
    public BrowsingHistory getBrowsingHistory(String username) {
        return null;
    }
}
