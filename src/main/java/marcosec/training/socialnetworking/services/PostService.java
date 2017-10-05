package marcosec.training.socialnetworking.services;

import java.util.Calendar;
import java.util.List;

public interface PostService
{
    void publishNewPost(String username, String message, Calendar time);
    List<String> readPostOf(String username);
    void addNewFollower(String username, String followedUsername);
    List<String> readWallOf(String username);
}
