package marcosec.training.socialnetworking.post.dao;

import marcosec.training.socialnetworking.post.Post;

import java.util.Calendar;
import java.util.List;

public interface PostDao
{
    List<Post> getAllPostsOf(String username);
    void newPost(String username, String message, Calendar time);
}
