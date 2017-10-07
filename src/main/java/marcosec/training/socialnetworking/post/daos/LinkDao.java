package marcosec.training.socialnetworking.post.daos;

import java.util.Collection;

public interface LinkDao
{
    Collection<String> getUsersFollowedBy(String username);
    void addFollower(String username, String followedUser);
}
