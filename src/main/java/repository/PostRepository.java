package repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import entity.Post;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Szopa on 12/21/2016.
 */
public class PostRepository {

    public List<Post> getAllPosts() {

        // TODO dszopa 12/21/16 - These first three lines should probably be made into a bean
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase testDatabase = mongoClient.getDatabase("testdb");
        MongoCollection posts = testDatabase.getCollection("post");


        MongoCursor<Document> cursor = posts.find().iterator();

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
