package framworks_drivers_layer.dataAccess;

import application_business_rules_layer.postUseCases.PostDsGateway;
import application_business_rules_layer.postUseCases.PostDsRequestModel;
import enterprise_business_rules_layer.postEntities.Post;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        headers.put("ID", 7);

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
                ArrayList<String> tags = new ArrayList<String>(Arrays.asList(String.valueOf(col[headers.get("Tags")]).split(":")));
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String creationTimeText = String.valueOf(col[headers.get("CreationTime")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText, dateTimeFormatter);
                String id = String.valueOf(col[headers.get("ID")]);
                PostDsRequestModel post = new PostDsRequestModel(username, title, description, price, tags, ldt, id);
                posts.put(post.getId(), post);
            }

            reader.close();
        }
    }

    /**
     * Add requestModel to storage.
     * @param requestModel the post's information to save.
     */
    @Override
    public void save(PostDsRequestModel requestModel) {
        posts.put(requestModel.getId(), requestModel);
        this.save();
    }

    /**
     * Save the information of the post in the csv file
     */
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
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String dateStr = post.getCreationTime().format(dateTimeFormatter);;

//                String line = "%s, %s, %s, %s, %s, %s, %s".formatted(
//                        post.get_username(), post.get_title(), post.get_description(),
//                        String.valueOf(post.get_price()), post.get_status(),
//                        str_post, dateStr);
                String line = ""+post.getUsername()+","+post.getTitle()+","+post.getDescription()+","+
                        post.getPrice() +","+post.getStatus()+","+str_post+","+dateStr+","+post.getId();
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        posts.remove(id);
        this.save();
    }



    /**
     * @param Tags     list of tags that are used to find Post object with these tags
     * @return return a list of Post objects of length at most 30 that contain at least one tag in Tags
     */
    @Override
    public List<Post> findPosts(List<String> Tags) {
        List<Post> posts = new ArrayList<>();
        for(PostDsRequestModel postDsRequestModel: this.posts.values()){
            for (String tag: Tags){
                if (postDsRequestModel.getTags().contains(tag) && posts.size() < 5){
                    posts.add(new Post(postDsRequestModel.getUsername(),
                            postDsRequestModel.getTitle(), postDsRequestModel.getDescription(),
                            postDsRequestModel.getPrice(), postDsRequestModel.getTags(),postDsRequestModel.getId()));
                    break;
                }
            }

        }

        return posts;
    }

    /**
     * @param keyword want to find
     * @return Posts with keyword in tags
     */
    @Override
    public List<Post> findPostsWithKeyword(String keyword) {
        List<Post> posts = new ArrayList<>();
        for(PostDsRequestModel postDsRequestModel: this.posts.values()){
            if (posts.size() < 10){
                if(postDsRequestModel.getTitle().toLowerCase().strip().contains(keyword.toLowerCase().strip())){
                    posts.add(new Post(postDsRequestModel.getUsername(),
                            postDsRequestModel.getTitle(), postDsRequestModel.getDescription(),
                            postDsRequestModel.getPrice(), postDsRequestModel.getTags(),postDsRequestModel.getId()));
                } else{
                    for(String tag: postDsRequestModel.getTags()){
                        if (tag.toLowerCase().strip().equals(keyword.toLowerCase().strip())){
                            posts.add(new Post(postDsRequestModel.getUsername(),
                                    postDsRequestModel.getTitle(), postDsRequestModel.getDescription(),
                                    postDsRequestModel.getPrice(), postDsRequestModel.getTags(),postDsRequestModel.getId()));
                        }

                    }
                }


            }
        }
        return posts;
    }

}
