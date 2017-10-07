package marcosec.training.socialnetworking.link.dao;

import marcosec.training.socialnetworking.post.daos.impl.LinkDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LinkDaoImplTest
{

    private LinkDaoImpl linkDao;

    @Before
    public void setup()
    {
        linkDao = new LinkDaoImpl();
    }

    @Test
    public void shouldAddNewLinkUserIfDoesNotExist()
    {
        linkDao.addFollower("Alice","Bob");

        assertThat(linkDao.getLinks().get("Alice"),hasItem("Bob"));
    }

    @Test
    public void shouldAddNewFollowerToUsername()
    {
        linkDao.addFollower("Alice","Bob");
        linkDao.addFollower("Alice","Charlie");

        assertThat(linkDao.getLinks().get("Alice"),hasItem("Bob"));
        assertThat(linkDao.getLinks().get("Alice"),hasItem("Charlie"));
    }

    @Test
    public void shouldRetrieveAllUsersFollowedByAGivenUsername()
    {
        linkDao.addFollower("Alice","Bob");
        linkDao.addFollower("Alice","Charlie");

        Collection<String> followed = linkDao.getUsersFollowedBy("Alice");

        assertEquals(2, followed.size());
    }
}