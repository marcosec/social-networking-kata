package marcosec.training.socialnetworking.post;

import java.util.Calendar;

public class Post
{
    private String username;
    private String message;
    private Calendar time;

    public Post(String username, String message, Calendar time)
    {
        this.username = username;
        this.message = message;
        this.time = time;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Calendar getTime()
    {
        return time;
    }

    public void setTime(Calendar time)
    {
        this.time = time;
    }
}
