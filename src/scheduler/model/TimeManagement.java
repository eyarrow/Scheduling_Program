package scheduler.model;

import java.util.TimeZone;

public abstract class TimeManagement {

    public static String returnZoneID() {
        String tz = TimeZone.getDefault().getDisplayName();
        return tz;
    }
}
