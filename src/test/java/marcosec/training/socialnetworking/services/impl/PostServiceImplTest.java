package marcosec.training.socialnetworking.services.impl;

import marcosec.training.socialnetworking.link.dao.LinkDao;
import marcosec.training.socialnetworking.link.dao.LinkDaoImpl;
import marcosec.training.socialnetworking.post.Post;
import marcosec.training.socialnetworking.post.dao.PostDao;
import marcosec.training.socialnetworking.post.dao.PostDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

public class PostServiceImplTest
{
    private PostServiceImpl postService;
    private PostDao postDao;
    private LinkDao linkDao;

    @Before
    public void setup()
    {
        postDao = new PostDaoImpl();
        linkDao = new LinkDaoImpl();

        postService = new PostServiceImpl(postDao,linkDao);
    }

    @Test
    public void shouldAddNewPost()
    {
        postService.publishNewPost("Alice","Nice day",new GregorianCalendar());

        List<Post> alicePost = postDao.getAllPostsOf("Alice");

        assertEquals(1, alicePost.size());
        assertEquals("Nice day", alicePost.get(0).getMessage());
    }


    @Test
    public void shouldAddNewFollowerToUsername()
    {
        postService.addNewFollower("Alice","Bob");

        Collection<String> followed = linkDao.getUsersFollowedBy("Alice");
        assertThat(followed, hasItem("Bob"));
    }

}