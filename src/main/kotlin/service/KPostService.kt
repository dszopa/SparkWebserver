package service

import entity.KPost
import repository.KPostRepository

class KPostService private constructor() {
    private var postRepository : KPostRepository? = null

    init {
        postRepository = KPostRepository.instance
    }

    val allPosts: List<KPost> get() = postRepository!!.allPosts

    private object Holder { val INSTANCE = KPostService() }

    companion object {
        val instance : KPostService by lazy { Holder.INSTANCE }
    }
}
