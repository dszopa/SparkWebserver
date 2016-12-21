package service;

import entity.Post;
import repository.PostRepository;

import java.util.List;

public class PostService {

    private static PostService instance = null;
    private PostRepository postRepository = null;

    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        return instance;
    }

    private PostService() {
        postRepository = PostRepository.getInstance();
    }

    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }
}
