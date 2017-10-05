package marcosec.training.socialnetworking.command.impl;

import marcosec.training.socialnetworking.command.Command;
import marcosec.training.socialnetworking.services.PostService;

import java.util.Calendar;

public class WallCommand implements Command
{
    private PostService postService;

    public WallCommand(PostService postService)
    {
        this.postService = postService;
    }

    @Override
    public String execute(String username, String message, Calendar time)
    {
        StringBuilder builder = new StringBuilder();
        postService.readWallOf( username).stream().forEach(post -> builder.append(post).append("\n"));
        return builder.toString();
    }
}
