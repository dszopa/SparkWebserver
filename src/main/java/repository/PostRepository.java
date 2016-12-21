package repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import entity.Post;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public final class PostRepository {

    private static PostRepository instance = null;

    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }
        return instance;
    }

    private PostRepository() {
        // Blank but used for singleton purposes
    }

    public List<Post> getAllPosts() {
        MongoCollection postCollection = DatabaseConnection.getPostCollection();
        MongoCursor<Document> cursor = postCollection.find().iterator();

        List<Post> postList = new ArrayList<>();

        try {
            while(cursor.hasNext()) {
                Document document = cursor.next();

                Post newPost = new Post();
                newPost.setId(document.get("_id").toString());
                newPost.setTitle(document.getString("title"));
                newPost.setNameOfPoster(document.getString("nameOfPoster"));
                newPost.setText(document.getString("text"));

                postList.add(newPost);
            }
        } finally {
            cursor.close();
        }

        return postList;
    }
}
