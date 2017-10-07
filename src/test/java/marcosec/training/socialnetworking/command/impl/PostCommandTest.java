package marcosec.training.socialnetworking.command.impl;

import marcosec.training.socialnetworking.services.SocialNetworkService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;

import static org.mockito.Mockito.verify;

public class PostCommandTest
{
    private PostCommand postCommand;
    @Mock
    private SocialNetworkService socialNetworkService;

    @Test
    public void shouldPost()
    {
        MockitoAnnotations.initMocks(this);
        postCommand = new PostCommand(socialNetworkService);
        Calendar now = Calendar.getInstance();

        postCommand.execute("Alice", "a message", now);

        verify(socialNetworkService).publishNewPost("Alice","a message", now);
    }

}