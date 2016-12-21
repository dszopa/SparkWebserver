package repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnection {

    // Static database variable so that we only create one connection
    private static MongoDatabase database = new MongoClient("localhost", 27017).getDatabase("testdb");

    public static MongoCollection getPostCollection() {
        return database.getCollection("post");
    }
}
