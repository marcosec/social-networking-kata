package marcosec.training.socialnetworking.processor;

import marcosec.training.socialnetworking.command.Command;
import marcosec.training.socialnetworking.command.impl.FollowCommand;
import marcosec.training.socialnetworking.command.impl.PostCommand;
import marcosec.training.socialnetworking.command.impl.ReadCommand;
import marcosec.training.socialnetworking.command.impl.WallCommand;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

public class InputProcessorImplTest
{

    private InputProcessorImpl inputProcessor;
    @Mock
    private PostCommand postCommand;
    @Mock
    private ReadCommand readCommand;
    @Mock
    private FollowCommand followCommand;
    @Mock
    private WallCommand wallCommand;

    @Test
    public void shouldParseInput_post()
    {
        MockitoAnnotations.initMocks(this);
        HashMap<String, Command> commandMap = new HashMap<>();
        commandMap.put("->",postCommand);

        inputProcessor = new InputProcessorImpl(commandMap);

        inputProcessor.process("A -> B");

        verify(postCommand).execute(eq("A"),eq("B"), anyObject());
    }

    @Test
    public void shouldParseInput_read()
    {
        MockitoAnnotations.initMocks(this);
        HashMap<String, Command> commandMap = new HashMap<>();
        commandMap.put(null,readCommand);

        inputProcessor = new InputProcessorImpl(commandMap);

        inputProcessor.process("A");

        verify(readCommand).execute(eq("A"),eq(null), anyObject());
    }

    @Test
    public void shouldParseInput_follows()
    {
        MockitoAnnotations.initMocks(this);
        HashMap<String, Command> commandMap = new HashMap<>();
        commandMap.put("follows",followCommand);

        inputProcessor = new InputProcessorImpl(commandMap);

        inputProcessor.process("A follows B");

        verify(followCommand).execute(eq("A"),eq("B"), anyObject());
    }

    @Test
    public void shouldParseInput_wall()
    {
        MockitoAnnotations.initMocks(this);
        HashMap<String, Command> commandMap = new HashMap<>();
        commandMap.put("wall",wallCommand);

        inputProcessor = new InputProcessorImpl(commandMap);

        inputProcessor.process("A wall");

        verify(wallCommand).execute(eq("A"),eq(null), anyObject());
    }
}