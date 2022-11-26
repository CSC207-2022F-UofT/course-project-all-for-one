package gateway;

import entities.Post;
import use_case.PostDsGateway;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FilePost implements PostDsGateway {

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
        posts.put(requestModel.getUsername(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (PostDsRequestModel post : posts.values()) {
                String str_post = post.getTags().toString();
                str_post = str_post.replace("[","").
                        replace("]","").replace(" ","").
                        replace(",",":");
                String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                        post.getUsername(), post.getTitle(), post.getDescription(),
                        post.getPrice(), post.getStatus(),
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
                if (postDsRequestModel.getTags().contains(tag) && posts.size() < 30){
                    posts.add(new Post(postDsRequestModel.getUsername(),
                            postDsRequestModel.getTitle(), postDsRequestModel.getDescription(),
                            postDsRequestModel.getPrice(), postDsRequestModel.getTags()));
                }
            }
        }
        return posts;
    }

}




