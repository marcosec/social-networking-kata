package marcosec.training.socialnetworking.command.impl;

import marcosec.training.socialnetworking.command.Command;
import marcosec.training.socialnetworking.services.SocialNetworkService;

import java.util.Calendar;

public class PostCommand implements Command
{
    private SocialNetworkService socialNetworkService;

    public PostCommand(SocialNetworkService socialNetworkService)
    {
        this.socialNetworkService = socialNetworkService;
    }

    @Override
    public String execute(String username, String message, Calendar time)
    {
        socialNetworkService.publishNewPost(username,message,time);
        return "";
    }
}
