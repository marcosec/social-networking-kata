package marcosec.training.socialnetworking.command.impl;

import marcosec.training.socialnetworking.command.Command;
import marcosec.training.socialnetworking.services.PostService;

import java.util.Calendar;

public class ReadCommand implements Command
{
    private PostService postService;

    public ReadCommand(PostService postService)
    {
        this.postService = postService;
    }

    @Override
    public String execute(String username, String message, Calendar time)
    {
        StringBuilder builder = new StringBuilder();
        postService.readPostOf(username).stream().forEach(post -> builder.append(post).append("\n"));
        return builder.toString();
    }
}
