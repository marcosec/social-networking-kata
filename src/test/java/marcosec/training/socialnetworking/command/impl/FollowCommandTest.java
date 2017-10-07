package marcosec.training.socialnetworking.command.impl;

import marcosec.training.socialnetworking.services.SocialNetworkService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;

import static org.mockito.Mockito.verify;

public class FollowCommandTest
{
    private FollowCommand followCommand;
    @Mock
    private SocialNetworkService socialNetworkService;

    @Test
    public void shouldFollow()
    {
        MockitoAnnotations.initMocks(this);
        followCommand = new FollowCommand(socialNetworkService);
        Calendar now = Calendar.getInstance();

        followCommand.execute("Alice", "Bob", now);

        verify(socialNetworkService).addNewFollower("Alice","Bob");
    }
}