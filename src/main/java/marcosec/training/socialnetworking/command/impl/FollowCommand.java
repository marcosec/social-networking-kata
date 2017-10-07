package marcosec.training.socialnetworking.command.impl;

import marcosec.training.socialnetworking.command.Command;
import marcosec.training.socialnetworking.services.SocialNetworkService;

import java.util.Calendar;

public class FollowCommand implements Command
{

    private SocialNetworkService socialNetworkService;

    public FollowCommand(SocialNetworkService socialNetworkService)
    {
        this.socialNetworkService = socialNetworkService;
    }

    @Override
    public String execute(String username, String followedUsername, Calendar time)
    {
        socialNetworkService.addNewFollower(username,followedUsername);
        return "";
    }
}
