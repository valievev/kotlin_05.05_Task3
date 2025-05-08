import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }
    @org.junit.Test
    fun addPost() {
        val prevId = WallService.getNextId()
        WallService.addPost(Post(text = "autoTestAdd"))
        assertEquals(false, prevId == WallService.getNextId())
    }

    @org.junit.Test
    fun updatePostTrue() {
        WallService.addPost(Post(text = "autoTestUpdate"))
        assertEquals(
            true,
            WallService.updatePost(Post(id = WallService.getNextId() - 1, text = "Update"))
        )
    }

    @org.junit.Test
    fun updatePostFalse() {
        WallService.addPost(Post(text = "autoTestUpdate"))
        assertEquals(
            false,
            WallService.updatePost(Post(id = WallService.getNextId(), text = "Update"))
        )
    }
}