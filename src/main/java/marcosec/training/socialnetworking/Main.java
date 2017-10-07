package marcosec.training.socialnetworking;

import marcosec.training.socialnetworking.command.Command;
import marcosec.training.socialnetworking.command.impl.FollowCommand;
import marcosec.training.socialnetworking.command.impl.PostCommand;
import marcosec.training.socialnetworking.command.impl.ReadCommand;
import marcosec.training.socialnetworking.command.impl.WallCommand;
import marcosec.training.socialnetworking.link.dao.LinkDaoImpl;
import marcosec.training.socialnetworking.post.dao.PostDaoImpl;
import marcosec.training.socialnetworking.processor.InputProcessor;
import marcosec.training.socialnetworking.processor.InputProcessorImpl;
import marcosec.training.socialnetworking.services.SocialNetworkService;
import marcosec.training.socialnetworking.services.impl.SocialNetworkServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main
{

    public static final String PROMPT_COMMAND = "> ";
    public static final String EXIT_COMMAND = "0";

    public static void main(String[] args)
    {
        SocialNetworkService socialNetworkService = new SocialNetworkServiceImpl(new PostDaoImpl(),new LinkDaoImpl());

        HashMap<String, Command> commandMap = new HashMap<>();
        commandMap.put("->",new PostCommand(socialNetworkService));
        commandMap.put(null,new ReadCommand(socialNetworkService));
        commandMap.put("follows",new FollowCommand(socialNetworkService));
        commandMap.put("wall",new WallCommand(socialNetworkService));

        InputProcessor inputProcessor = new InputProcessorImpl(commandMap);

        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command;
            do
            {
                System.out.print(PROMPT_COMMAND);
                command = reader.readLine();
                inputProcessor.process(command);
            }
            while (!EXIT_COMMAND.equals(command));

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
