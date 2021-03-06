package marcosec.training.socialnetworking.services.impl;

import marcosec.training.socialnetworking.post.MessageFormatter;
import marcosec.training.socialnetworking.post.Post;
import marcosec.training.socialnetworking.post.daos.LinkDao;
import marcosec.training.socialnetworking.post.daos.PostDao;
import marcosec.training.socialnetworking.services.SocialNetworkService;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SocialNetworkServiceImpl implements SocialNetworkService
{
    private PostDao postDao;
    private LinkDao linkDao;

    public SocialNetworkServiceImpl(PostDao postDao, LinkDao linkDao)
    {
        this.postDao = postDao;
        this.linkDao = linkDao;
    }

    public SocialNetworkServiceImpl()
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
        List<Post> posts = postDao.getAllPostsOf(username);

        List<Post> postsSortedByTime = posts.stream()
                                        .sorted(Comparator.comparing(Post::getTime).reversed())
                                        .collect(Collectors.toList());

        List<String> formattedPosts = new ArrayList<>();

        postsSortedByTime.stream()
                .forEach(post ->
                        formattedPosts.add(MessageFormatter.format(post.getMessage(),post.getTime()))
                );

        return formattedPosts;
    }

    @Override
    public void addNewFollower(String username, String followedUsername)
    {
        linkDao.addFollower(username,followedUsername);
    }

    @Override
    public List<String> readWallOf(String username)
    {
        List<Post> usernamePosts = postDao.getAllPostsOf(username);
        Collection<String> usersFollowed = linkDao.getUsersFollowedBy(username);

        List<Post> followedPosts = new ArrayList<>();
        CollectionUtils.emptyIfNull(usersFollowed).stream()
                .forEach(user ->
                        followedPosts.addAll(postDao.getAllPostsOf(user))
                );

        List<Post> mergedPosts = Stream.concat(usernamePosts.stream(), followedPosts.stream()).collect(Collectors.toList());

        List<Post> postsSortedByTime = mergedPosts.stream()
                .sorted(Comparator.comparing(Post::getTime).reversed())
                .collect(Collectors.toList());

        List<String> formattedPosts = new ArrayList<>();

        postsSortedByTime.stream()
                .forEach(post ->
                        formattedPosts.add(
                                new StringBuilder(post.getUsername())
                                        .append(" - ")
                                        .append(MessageFormatter.format(post.getMessage(),post.getTime()))
                                        .toString()
                        )
                );

        return formattedPosts;

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
