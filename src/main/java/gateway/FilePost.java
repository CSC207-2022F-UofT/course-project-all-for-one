package gateway;

import entities.Post;
import use_case.PostDsGateway;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FilePost implements PostDsGateway, RecommendationGateway {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, PostDsRequestModel> posts = new HashMap<>();

    public FilePost(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("Username", 0);
        headers.put("Title", 1);
        headers.put("Description", 2);
        headers.put("Price", 3);
        headers.put("Status", 4);
        headers.put("Tags", 5);
        headers.put("CreationTime", 6);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String username = String.valueOf(col[headers.get("Username")]);
                String title = String.valueOf(col[headers.get("Title")]);
                String description = String.valueOf(col[headers.get("Description")]);
                double price = Double.parseDouble(col[headers.get("Price")]);
                String status = String.valueOf(col[headers.get("Status")]);
                ArrayList<String> tags = (ArrayList<String>) Arrays.asList(String.valueOf(col[headers.get("Tags")]).split(":"));
                String creationTimeText = String.valueOf(col[headers.get("CreationTime")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                PostDsRequestModel post = new PostDsRequestModel(username, title, description, price, tags, ldt);
                posts.put(username, post);
            }

            reader.close();
        }
    }

    /**
     * Add requestModel to storage.
     * @param requestModel the user information to save.
     */
    @Override
    public void save(PostDsRequestModel requestModel) {
        posts.put(requestModel.get_username(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (PostDsRequestModel post : posts.values()) {
                String str_post = post.get_tags().toString();
                str_post = str_post.replace("[","").
                        replace("]","").replace(" ","").
                        replace(",",":");
                String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                        post.get_username(), post.get_title(), post.get_description(),
                        post.get_price(), post.get_status(),
                        str_post, post.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param Tags     list of tags that are used to find Post object with these tags
     * @return return a list of Post objects of length at most 30 that contain at least one tag in Tags
     */
    @Override
    public List<Post> findPosts(List<String> Tags) {
        List<Post> posts = new ArrayList<>();
        for(String tag : Tags){
            for(PostDsRequestModel postDsRequestModel: this.posts.values()){
                if (postDsRequestModel.get_tags().contains(tag) && posts.size() < 30){
                    posts.add(new Post(postDsRequestModel.get_username(),
                            postDsRequestModel.get_title(), postDsRequestModel.get_description(),
                            postDsRequestModel.get_price(), postDsRequestModel.get_tags()));
                }
            }
        }
        return posts;
    }

    /**
     * @param username username of the user that is acting
     * @return the purchase history object that is owned by the user with username in database
     */
    @Override
    public List<String> getPurchaseHistoryTags(String username) {
        return null;
    }

    /**
     * @param username username of the user that is acting
     * @return the browsing history object that is owned by the user with username in database
     */
    @Override
    public List<String> getBrowsingHistoryTags(String username) {
        return null;
    }
}




