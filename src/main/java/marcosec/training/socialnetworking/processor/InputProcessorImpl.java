package marcosec.training.socialnetworking.processor;

import marcosec.training.socialnetworking.command.Command;

import java.util.Calendar;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputProcessorImpl implements InputProcessor
{
    private static final String REGEX = "(\\w+)(\\s(->|follows|wall)(\\s(.*))*)*";

    private Map<String, Command> commandMap;

    public InputProcessorImpl(Map<String, Command> commandMap)
    {
        this.commandMap = commandMap;
    }

    @Override
    public void process(String input)
    {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        matcher.matches();

        String username = matcher.group(1);
        String command = matcher.group(3);
        String argument = matcher.group(5);

        System.out.println(commandMap.get(command).execute(username, argument, Calendar.getInstance()));

    }

}
