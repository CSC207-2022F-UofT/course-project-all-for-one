public Map<Integer, PostModel> postsReader(String postPath) throws IOException {
        /**
         * This method is for reading posts.csv file.
         *
         * @param postPath the path of the posts.csv file
         * @return a map of posts
         * @throws IOException
         */
        File csvFile = new File(postPath);
        Map<String, Integer> headers = new HashMap<>();
        Map<Integer, PostModel> posts = new HashMap<>();
        headers.put("id", 0);
        headers.put("userid", 1);
        headers.put("time", 2);
        headers.put("content", 3);
        headers.put("num-liked", 4);
        headers.put("num-viewed", 5);
        headers.put("user-liked", 6);
        headers.put("list_comment_id", 7);
        headers.put("post_title", 8);
        headers.put("topic", 9);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header

        String row;
        while ((row = reader.readLine()) != null) {
        String[] col = row.split(",");
        int id = Integer.parseInt(col[headers.get("id")]);
        int userid = Integer.parseInt(col[headers.get("userid")]);
        String time = String.valueOf(col[headers.get("time")]);
        String content = String.valueOf(col[headers.get("content")]);
        int num_liked = Integer.parseInt(col[headers.get("num-liked")]);
        int num_viewed = Integer.parseInt(col[headers.get("num-viewed")]);
        String list_comment_id = String.valueOf(col[headers.get("list_comment_id")]);
        String list_user_id = String.valueOf(col[headers.get("user-liked")]);
        String post_title = String.valueOf(col[headers.get("post_title")]);
        String topic = String.valueOf(col[headers.get("topic")]);
        String[] userIds = list_user_id.split(" ");
        String[] commentIds = list_comment_id.split(" ");
        ArrayList<Integer> iList_comment_id = new ArrayList<>();
        ArrayList<Integer> iList_user_id = new ArrayList<>();
        if (!list_user_id.equals("")) {
        for (String commentId :
        commentIds) {
        iList_comment_id.add(Integer.parseInt(commentId));
        }
        }
        if (!list_comment_id.equals("")) {
        for (String userId :
        userIds) {
        iList_user_id.add(Integer.parseInt(userId));
        }
        }


        PostModel post = new PostModel(post_title,
        userid,
        id,
        content,
        time,
        num_liked,
        num_viewed,
        iList_user_id,
        iList_comment_id,

        topic);
        posts.put(id, post);
        }

        reader.close();
        return posts;
        }