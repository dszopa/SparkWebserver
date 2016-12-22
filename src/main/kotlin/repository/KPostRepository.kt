package repository

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoCursor
import entity.KPost
import org.bson.Document
import java.util.*

class KPostRepository private constructor() {// Blank but used for singleton purposes
    val allPosts: List<KPost>
        get() {
            val postCollection : MongoCollection<Document> = KDatabaseConnection.postCollection
            val cursor : MongoCursor<Document> = postCollection.find().iterator()

            val postList = ArrayList<KPost>()

            try {
                while (cursor.hasNext()) {
                    val document : Document = cursor.next()

                    val newPost = KPost()
                    newPost.id = document.get("_id").toString()
                    newPost.title = document.getString("title")
                    newPost.nameOfPoster = document.getString("nameOfPoster")
                    newPost.text = document.getString("text")

                    postList.add(newPost)
                }
            } finally {
                cursor.close()
            }

            return postList
        }

    private object Holder { val INSTANCE = KPostRepository() }

    companion object {
        val instance : KPostRepository by lazy { Holder.INSTANCE }
    }
}
