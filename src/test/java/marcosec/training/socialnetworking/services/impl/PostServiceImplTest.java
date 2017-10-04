package marcosec.training.socialnetworking.services.impl;

import marcosec.training.socialnetworking.link.dao.LinkDao;
import marcosec.training.socialnetworking.link.dao.LinkDaoImpl;
import marcosec.training.socialnetworking.post.Post;
import marcosec.training.socialnetworking.post.dao.PostDao;
import marcosec.training.socialnetworking.post.dao.PostDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
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
        postService.publishNewPost("Alice","Nice day", Calendar.getInstance());

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

    @Test
    public void shouldPrintAllPostsOfUsername()
    {

        Calendar twoMinutesAgo = Calendar.getInstance();
        twoMinutesAgo.add(Calendar.MINUTE, -2);

        Calendar oneHourAgo = Calendar.getInstance();
        oneHourAgo.add(Calendar.HOUR, -1);

        Calendar now = Calendar.getInstance();


        postService.publishNewPost("Alice","Nice day", twoMinutesAgo);
        postService.publishNewPost("Alice","Gym time", oneHourAgo);
        postService.publishNewPost("Alice","Good night", now);

        List<String> alicePosts = postService.readPostOf("Alice");

        assertEquals("Good night (0 seconds ago)", alicePosts.get(0));
        assertEquals("Nice day (2 minutes ago)", alicePosts.get(1));
        assertEquals("Gym time (1 hour ago)", alicePosts.get(2));
    }

}