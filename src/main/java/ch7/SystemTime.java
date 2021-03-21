package ch7;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

public class SystemTime {

    public static void setDate(LocalDateTime date) {
        SystemTime.date = date;
    }

    public static void resetDate()
    {
        date = LocalDateTime.MIN;
    }

    private static LocalDateTime date;

    public static LocalDateTime now() {
        if (date != null && !date.isEqual(LocalDateTime.MIN)) {
            return date;
        }
        return LocalDateTime.now();
    }
}
