package marcosec.training.socialnetworking.command.impl;

import marcosec.training.socialnetworking.command.Command;
import marcosec.training.socialnetworking.services.PostService;

import java.util.Calendar;

public class PostCommand implements Command
{
    private PostService postService;

    public PostCommand(PostService postService)
    {
        this.postService = postService;
    }

    @Override
    public String execute(String username, String message, Calendar time)
    {
        postService.publishNewPost(username,message,time);
        return "";
    }
}
