package marcosec.training.socialnetworking.command.impl;

import marcosec.training.socialnetworking.services.PostService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;

import static org.mockito.Mockito.verify;

public class PostCommandTest
{
    private PostCommand postCommand;
    @Mock
    private PostService postService;

    @Test
    public void shouldPost()
    {
        MockitoAnnotations.initMocks(this);
        postCommand = new PostCommand(postService);
        Calendar now = Calendar.getInstance();

        postCommand.execute("Alice", "a message", now);

        verify(postService).publishNewPost("Alice","a message", now);
    }

}