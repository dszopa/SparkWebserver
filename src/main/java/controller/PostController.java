package controller;

import entity.Post;
import service.PostService;
import spark.Spark;
import transformer.JsonTransformer;

import java.util.List;

public class PostController {

    private static PostController instance = null;

    public static PostController getInstance() {
        if (instance == null) {
            instance = new PostController();
        }
        return instance;
    }

    private PostController() {
        PostService postService = PostService.getInstance();

        Spark.get("/posts", ((request, response) -> {
            List<Post> posts = postService.getAllPosts();
            return posts;
        }), new JsonTransformer());
    }
}
