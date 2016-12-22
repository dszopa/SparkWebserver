package controller

import service.KPostService
import spark.Spark
import transformer.toJson

class KPostController private constructor() {
    init {
        val postService = KPostService.instance
        Spark.get("/posts", { req, res -> postService.allPosts }, ::toJson)
    }

    private object Holder { val INSTANCE = KPostController() }

    companion object {
        val instance : KPostController by lazy { Holder.INSTANCE }
    }
}
