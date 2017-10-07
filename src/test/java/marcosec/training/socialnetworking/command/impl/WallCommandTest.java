package marcosec.training.socialnetworking.command.impl;

import marcosec.training.socialnetworking.services.SocialNetworkService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Calendar;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class WallCommandTest
{

    private WallCommand wallCommand;
    @Mock
    private SocialNetworkService socialNetworkService;

    @Test
    public void shouldReadWall()
    {
        MockitoAnnotations.initMocks(this);
        wallCommand = new WallCommand(socialNetworkService);


        when(socialNetworkService.readWallOf("Alice")).thenReturn(Arrays.asList("Alice - post 1","Bob - post 2","Charlie - post 3"));

        String printedPosts = wallCommand.execute("Alice", "", Calendar.getInstance());

        assertEquals("Alice - post 1\nBob - post 2\nCharlie - post 3\n",printedPosts);

    }
}