package scheduler.util;

import java.sql.Time;
import java.util.Date;
import java.util.TimeZone;

/**
 * Provides functionality to implement time related functions.
 */
public abstract class TimeManagement {


    /**
     * Get the timezone of the user's system.
     * @return a timezone object
     */
    public static TimeZone returnTimeZone() {
        String tzTime = TimeZone.getDefault().getID();
        TimeZone tz = TimeZone.getTimeZone(tzTime);
        return tz;
    }

    /**
     * Get the TimeZone ID of the user's system.
     * @return the Timezone ID as a string
     */
    public static String returnTimeZoneID () {
        String tzTime = TimeZone.getDefault().getID();
        return tzTime;
    }

    /**
     * Get a human readable string that indicates what timezone is set on the user's
     * system. This does account for daylight saving time if that is applicable.
     * @return A string in Long format representing the user systems' timezone
     */
    public static String returnZoneIDString() {
        String tzTime = TimeZone.getDefault().getID();
        TimeZone tz = TimeZone.getTimeZone(tzTime);

        Date date = new Date();
        boolean daylight = tz.inDaylightTime(date);

        String tzString = TimeZone.getDefault().getDisplayName(daylight, TimeZone.LONG);
        return tzString;
    }
}
