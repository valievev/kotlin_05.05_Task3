import com.sun.org.apache.xpath.internal.axes.WalkerFactory

data class Post(val id: Int = 0, val text: String)

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 0

    fun addPost(post: Post): Post {
        val newPost = post.copy(id = nextId++)
        posts += newPost
        return posts.last()
    }

    fun updatePost(post: Post): Boolean {
        for ((index, postItem) in posts.withIndex()) {
            if (postItem.id == post.id) {
                posts[index] = posts[index].copy(text = post.text)
                return true
            }
        }
        return false
    }

    fun printPosts() {
        for (post in posts) {
            println(post)
        }
        println("-----------------------------")
    }

    fun getNextId(): Int {
        return nextId
    }

    fun clear() {
        posts = emptyArray()
        // nextId = 0
        // Нужно ли обновлять id?
        // если существуют ссылки на посты со внешних источников,
        // то лучше наверное чтобы они указывали на несуществующие посты,
        // а не на вновь созданные
    }
}

fun main() {
    val post1 = Post(text = "Это пост №1")
    val post2 = Post(text = "Это пост №2")
    val post3 = Post(text = "Это пост №3")
    val post4 = Post(text = "Это пост №4")

    WallService.addPost(post1)
    WallService.addPost(post2)
    WallService.addPost(post3)
    WallService.addPost(post4)

    WallService.printPosts()
    val newPost2 = Post(id = 1, text = "Это измененный пост №2")
    WallService.updatePost(newPost2)

    WallService.printPosts()
}