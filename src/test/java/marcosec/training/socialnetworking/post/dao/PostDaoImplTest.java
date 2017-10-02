package marcosec.training.socialnetworking.post.dao;

import marcosec.training.socialnetworking.post.Post;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

public class PostDaoImplTest
{
    private PostDaoImpl postDao;

    @Before
    public void setup()
    {
        postDao = new PostDaoImpl();
    }

    @Test
    public void shouldReturnZeroPostsForUnknownUsername()
    {
        List<Post> posts = postDao.getAllPostsOf("Unknown");
        assertTrue(posts.isEmpty());
    }

    @Test
    public void shouldReturnAllPostsByUsername()
    {
        Post alicePost = new Post("Alice","Wonderful day",new GregorianCalendar());
        postDao.setPosts(Arrays.asList(alicePost));

        List<Post> posts = postDao.getAllPostsOf("Alice");

        assertEquals(1, posts.size());
    }

    @Test
    public void shouldAddNewPost()
    {
        postDao.newPost("Alice","Wonderful day",new GregorianCalendar());

        List<Post> posts = postDao.getAllPostsOf("Alice");

        assertEquals(1, posts.size());
    }
}