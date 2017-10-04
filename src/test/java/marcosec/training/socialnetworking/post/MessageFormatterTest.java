package marcosec.training.socialnetworking.post;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class MessageFormatterTest
{

    @Test
    public void shouldFormatMessage_now()
    {
        Calendar now = Calendar.getInstance();

        String postFormatted = MessageFormatter.format("Wonderful day", now);

        assertEquals("Wonderful day (0 seconds ago)",postFormatted);
    }

    @Test
    public void shouldFormatMessage_oneSecondAgo()
    {
        Calendar onwSecondAgo = Calendar.getInstance();
        onwSecondAgo.add(Calendar.SECOND, -1);

        String postFormatted = MessageFormatter.format("Wonderful day", onwSecondAgo);

        assertEquals("Wonderful day (1 second ago)",postFormatted);
    }

    @Test
    public void shouldFormatMessage_secondsAgo()
    {
        Calendar twoMinutesAgo = Calendar.getInstance();
        twoMinutesAgo.add(Calendar.SECOND, -2);

        String postFormatted = MessageFormatter.format("Wonderful day", twoMinutesAgo);

        assertEquals("Wonderful day (2 seconds ago)",postFormatted);
    }

    @Test
    public void shouldFormatMessage_minutesAgo()
    {
        Calendar twoMinutesAgo = Calendar.getInstance();
        twoMinutesAgo.add(Calendar.MINUTE, -2);

        String postFormatted = MessageFormatter.format("Wonderful day", twoMinutesAgo);

        assertEquals("Wonderful day (2 minutes ago)",postFormatted);
    }

    @Test
    public void shouldFormatMessage_hoursAgo()
    {
        Calendar twoHoursAgo = Calendar.getInstance();
        twoHoursAgo.add(Calendar.HOUR, -2);

        String postFormatted = MessageFormatter.format("Wonderful day", twoHoursAgo);

        assertEquals("Wonderful day (2 hours ago)",postFormatted);
    }
}