package marcosec.training.socialnetworking.post;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MessageFormatter
{
    public static String format(String message, Calendar postingTime)
    {
        return new StringBuilder()
                .append(message)
                .append(" ")
                .append("(")
                .append(printDeltaTime(postingTime, Calendar.getInstance()))
                .append(")")
                .toString();
    }

    private static String printDeltaTime(Calendar startTime, Calendar endTime)
    {
        long deltaTime = endTime.getTimeInMillis() - startTime.getTimeInMillis();

        Integer deltaSeconds = Math.toIntExact(deltaTime / 1000);
        Integer deltaMinutes = deltaSeconds / 60;
        Integer deltaHours = deltaMinutes / 60;
        Integer deltaDays = deltaHours / 24;

        Map<String, Integer> deltaMap = new HashMap<>();
        deltaMap.put("day",deltaDays);
        deltaMap.put("hour",deltaHours);
        deltaMap.put("minute",deltaMinutes);
        deltaMap.put("second",deltaSeconds);

        Map.Entry<String, Integer> stringIntegerEntry = deltaMap.entrySet().stream().filter(d -> d.getValue() != 0).findFirst().get();

        return stringIntegerEntry.getValue() + " "+ pluralIfNeeded(stringIntegerEntry) +" ago";
    }

    private static String pluralIfNeeded(Map.Entry<String, Integer> stringIntegerEntry)
    {
        return stringIntegerEntry.getValue() > 1 ? stringIntegerEntry.getKey().concat("s") : stringIntegerEntry.getKey();
    }
}
