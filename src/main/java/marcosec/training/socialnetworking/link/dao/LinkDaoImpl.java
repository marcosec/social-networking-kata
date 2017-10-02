package marcosec.training.socialnetworking.link.dao;

import java.util.*;

public class LinkDaoImpl implements LinkDao
{
    private Map<String, Set<String>> links;

    public LinkDaoImpl()
    {
        links = new HashMap<>();
    }

    @Override
    public Collection<String> getUsersFollowedBy(String username)
    {
        return links.get(username);
    }

    @Override
    public void addFollower(String username, String followedUser)
    {
        if (!links.containsKey(username))
        {
            links.put(username,new HashSet<>());
        }
        links.get(username).add(followedUser);
    }

    public Map<String, Set<String>> getLinks()
    {
        return links;
    }
}
