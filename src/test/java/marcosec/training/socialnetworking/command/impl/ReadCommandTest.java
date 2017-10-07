package marcosec.training.socialnetworking.command.impl;

import marcosec.training.socialnetworking.services.SocialNetworkService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ReadCommandTest
{
    private ReadCommand readCommand;
    @Mock
    private SocialNetworkService socialNetworkService;

    @Test
    public void shouldRead()
    {
        MockitoAnnotations.initMocks(this);
        readCommand = new ReadCommand(socialNetworkService);


        when(socialNetworkService.readPostOf("Alice")).thenReturn(Arrays.asList("post 1","post 2","post 3"));

        String printedPosts = readCommand.execute("Alice", "", Calendar.getInstance());

        assertEquals("post 1\npost 2\npost 3\n",printedPosts);

    }
}