package marcosec.training.socialnetworking.post.daos.impl;

import marcosec.training.socialnetworking.post.Post;
import marcosec.training.socialnetworking.post.daos.PostDao;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class PostDaoImpl implements PostDao
{
    private List<Post> posts;

    public PostDaoImpl()
    {
        posts = new ArrayList<>();
    }

    @Override
    public List<Post> getAllPostsOf(String username)
    {
        return CollectionUtils.emptyIfNull(posts).stream()
                .filter(post -> username.equals(post.getUsername()))
                .collect(Collectors.toList());
    }

    @Override
    public void newPost(String username, String message, Calendar time)
    {
        posts.add(new Post(username,message,time));
    }

    public void setPosts(List<Post> posts)
    {
        this.posts = posts;
    }
}
