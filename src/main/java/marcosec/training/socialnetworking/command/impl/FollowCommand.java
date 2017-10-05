package marcosec.training.socialnetworking.command.impl;

import marcosec.training.socialnetworking.command.Command;
import marcosec.training.socialnetworking.services.PostService;

import java.util.Calendar;

public class FollowCommand implements Command
{

    private PostService postService;

    public FollowCommand(PostService postService)
    {
        this.postService = postService;
    }

    @Override
    public String execute(String username, String followedUsername, Calendar time)
    {
        postService.addNewFollower(username,followedUsername);
        return "";
    }
}
