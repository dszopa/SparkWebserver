package controller

import spark.Request
import spark.Response
import spark.Spark

class KPostController private constructor() {
    init {
        val postService = KPostService.instance
        Spark.get("/posts", {request : Request, response : Response -> {
            val posts = postService.allPosts
            posts
        }}, KJsonTransformer())
    }

    private object Holder { val INSTANCE = KPostController() }

    companion object {
        val instance : KPostController by lazy { Holder.INSTANCE }
    }
}
