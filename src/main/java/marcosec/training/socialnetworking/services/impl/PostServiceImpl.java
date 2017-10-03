package marcosec.training.socialnetworking.services.impl;

import marcosec.training.socialnetworking.link.dao.LinkDao;
import marcosec.training.socialnetworking.post.dao.PostDao;
import marcosec.training.socialnetworking.services.PostService;

import java.util.Calendar;
import java.util.List;

public class PostServiceImpl implements PostService
{
    private PostDao postDao;
    private LinkDao linkDao;

    public PostServiceImpl(PostDao postDao, LinkDao linkDao)
    {
        this.postDao = postDao;
        this.linkDao = linkDao;
    }

    public PostServiceImpl()
    {

    }


    @Override
    public void publishNewPost(String username, String message, Calendar time)
    {
        postDao.newPost(username,message,time);
    }

    @Override
    public List<String> readPostOf(String username)
    {
        return null;
    }

    @Override
    public void addNewFollower(String username, String followedUsername)
    {
        linkDao.addFollower(username,followedUsername);
    }


    public PostDao getPostDao()
    {
        return postDao;
    }

    public void setPostDao(PostDao postDao)
    {
        this.postDao = postDao;
    }

    public LinkDao getLinkDao()
    {
        return linkDao;
    }

    public void setLinkDao(LinkDao linkDao)
    {
        this.linkDao = linkDao;
    }
}
