package scheduler.model;

import java.sql.Time;
import java.util.Date;
import java.util.TimeZone;

public abstract class TimeManagement {

    public static boolean dayLightSavings;

    public static TimeZone returnTimeZone() {
        String tzTime = TimeZone.getDefault().getID();
        TimeZone tz = TimeZone.getTimeZone(tzTime);
        return tz;
    }

    public static String returnTimeZoneID () {
        String tzTime = TimeZone.getDefault().getID();
        return tzTime;
    }

    public static String returnZoneIDString() {
        String tzTime = TimeZone.getDefault().getID();
        TimeZone tz = TimeZone.getTimeZone(tzTime);

        Date date = new Date();
        boolean daylight = tz.inDaylightTime(date);

        String tzString = TimeZone.getDefault().getDisplayName(daylight, TimeZone.LONG);
        return tzString;
    }
}
