package repository

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import org.bson.Document

object KDatabaseConnection {

    // Static database variable so that we only create one connection
    private val database = MongoClient("localhost", 27017).getDatabase("testdb")

    val postCollection: MongoCollection<Document>
        get() = database.getCollection("post")
}
