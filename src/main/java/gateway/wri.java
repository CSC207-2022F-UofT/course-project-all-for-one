//
//
//public void postsWriter(String postsPath, Map<Integer, PostModel> posts) {
//        /**
//         * This method is for writing posts.csv file.
//         *
//         * @param postsPath the path of the posts.csv file
//         * @param posts a map of posts
//         */
//
//        Map<String, Integer> headers = new HashMap<>();
//
//        headers.put("id", 0);
//        headers.put("userid", 1);
//        headers.put("time", 2);
//        headers.put("content", 3);
//        headers.put("num-liked", 4);
//        headers.put("num-viewed", 5);
//        headers.put("user-liked", 6);
//        headers.put("list_comment_id", 7);
//        headers.put("post_title", 8);
//        headers.put("topic", 9);
//
//        BufferedWriter writer;
//        try {
//        writer = new BufferedWriter(new FileWriter(postsPath));
//        writer.write(String.join(",", headers.keySet()));
//        writer.newLine();
//        for (PostModel post : posts.values()) {
//        StringBuilder userLiked = new StringBuilder();
//        StringBuilder listComment = new StringBuilder();
//        ArrayList<Integer> userlikes = (ArrayList<Integer>)post.get().get(7);
//        ArrayList<Integer> listComments = (ArrayList<Integer>)post.get().get(8);
//        if(userlikes.size() > 0){
//        userLiked = new StringBuilder(String.valueOf(userlikes.get(0)));
//        for (int i = 1; i < userlikes.size(); i++) {
//        userLiked.append(" ").append(String.valueOf(userlikes.get(i)));
//        }
//        }
//        if(listComments.size() > 0) {
//        listComment = new StringBuilder(String.valueOf(listComments.get(0)));
//        for (int i = 1; i < listComments.size(); i++) {
//        listComment.append(" ").append(String.valueOf(listComments.get(i)));
//        }
//        }
//
//        String line = (
//        post.get().get(0) +","+
//        post.get().get(1) +","+
//        post.get().get(2) +","+
//        post.get().get(3) +","+
//        post.get().get(4) +","+
//        post.get().get(5) +","+
//        post.get().get(6) +","+
//        userLiked+","+
//        listComment+","+
//        post.get().get(9));
//        writer.write(line);
//        writer.newLine();
//        }
//
//        writer.close();
//
//        } catch (IOException e) {
//        throw new RuntimeException(e);
//        }
//        }