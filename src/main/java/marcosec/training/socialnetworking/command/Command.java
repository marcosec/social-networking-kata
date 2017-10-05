package marcosec.training.socialnetworking.command;

import java.util.Calendar;

public interface Command
{
    String execute(String username, String message, Calendar time);
}
