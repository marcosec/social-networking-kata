package marcosec.training.socialnetworking.command.impl;

import marcosec.training.socialnetworking.command.Command;
import marcosec.training.socialnetworking.services.SocialNetworkService;

import java.util.Calendar;

public class WallCommand implements Command
{
    private SocialNetworkService socialNetworkService;

    public WallCommand(SocialNetworkService socialNetworkService)
    {
        this.socialNetworkService = socialNetworkService;
    }

    @Override
    public String execute(String username, String message, Calendar time)
    {
        StringBuilder builder = new StringBuilder();
        socialNetworkService.readWallOf( username).stream().forEach(post -> builder.append(post).append("\n"));
        return builder.toString();
    }
}
