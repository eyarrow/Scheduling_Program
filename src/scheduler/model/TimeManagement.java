package scheduler.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.Dao.daoAppointment;
import scheduler.util.dialogueHandling;
import scheduler.util.dialogueReturnValues;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;

/**
 * Provides functionality to implement time related functions.
 */
public abstract class TimeManagement {

    private static ObservableList<LocalTime> hour_picker = FXCollections.observableArrayList();

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

        String tzString = ZoneId.systemDefault().toString();
        return tzString;
    }




    /**
     * Populates an Observable list with valid Appointment times for display.
     */
    public static void populateDateTimes() {

        ObservableList<String> concatTimes = FXCollections.observableArrayList();
        concatTimes.addAll("00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24");
        for(int i = 0; i < 24; ++i) {
            LocalTime time1 = LocalTime.of(Integer.parseInt(concatTimes.get(i)), 00);
            LocalTime time2 = LocalTime.of(Integer.parseInt(concatTimes.get(i)), 15);
            LocalTime time3 = LocalTime.of(Integer.parseInt(concatTimes.get(i)), 30);
            LocalTime time4 = LocalTime.of(Integer.parseInt(concatTimes.get(i)), 45);
            hour_picker.addAll(time1, time2, time3, time4);
        }

    }

    /**
     * Returns the list of times.
     * @return an Observable list of LocalTime objects
     */
    public static ObservableList<LocalTime> returnLocalTime() {
        return hour_picker;
    }

    /**
     * Checks the following: Whether appointment occurs within allowable business hours.
     * Business hours are currently defined as 8:00 AM EST - 10 PM EST Monday - Sunday. Also checks
     * to see if the end date is before the start date in LocalTime. Displays an error dialogue if errors
     * are present.
     * @param start Local Date, Requested Start date / time
     * @param end Local Date, Requested end time /date
     * @return true, if times pass validation. false if they do not.
     */
    public static boolean validateBusinessHours(LocalDateTime start, LocalDateTime end) {
        //create zoned time for start time
        ZonedDateTime localZonedStart = ZonedDateTime.of(start.toLocalDate(), start.toLocalTime(), ZoneId.of(returnTimeZoneID()));
        ZonedDateTime localZonedEnd = ZonedDateTime.of(end.toLocalDate(), end.toLocalTime(), ZoneId.of(returnTimeZoneID()));

        //setting valid start
        LocalTime validStartTime = LocalTime.of(8, 00);
        LocalDate validStartDate = start.toLocalDate();
        ZoneId eastern = ZoneId.of("America/New_York");
        ZonedDateTime validStartZoned = ZonedDateTime.of(validStartDate, validStartTime, eastern);

        //setting valid end
        LocalTime validEndTime = LocalTime.of(22, 00);
        LocalDate validEndDate = end.toLocalDate();
        ZonedDateTime validEndZoned = ZonedDateTime.of(validEndDate, validEndTime, eastern);

        //Convert inputs into UTC
        Instant UTC_start = localZonedStart.toInstant();
        Instant UTC_end = localZonedEnd.toInstant();


        //Convert valid times into UTC
        Instant UTC_valid_start = validStartZoned.toInstant();
        Instant UTC_valid_end = validEndZoned.toInstant();

        if(UTC_start.isBefore(UTC_valid_start) || UTC_start.isAfter(UTC_valid_end)) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.START_NOT_VALID);
            return false;
        }

        if(UTC_end.isAfter(UTC_valid_end) || UTC_end.isBefore(UTC_valid_start)) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.END_NOT_VALID);
            return false;
        }

        if(localZonedEnd.isBefore(localZonedStart)) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.END_BEFORE_START);
            return false;
        }


        return true;



    }

    /**
     * Checks whether new appointment time conflicts with an already scheduled appointment with the same customer.
     * @param AppointmentID Integer, Appointment ID. Should be 0 for a new appointment.
     * @param CustomerID Integer, Customer ID
     * @param start LocalDateTime, the start time proposed for the new appointment
     * @param end LocalDateTime, the end time proposed for the new appointment
     * @return The appointment which has a conflict. If there is no conflict the Appointment Object
     * that is returned is populated with null values, and a appointment id # of 0.
     */
    public static Appointment checkAppointmentTimeOverlap(int AppointmentID, int CustomerID, LocalDateTime start, LocalDateTime end) {
        LinkedList<Appointment> customerAppointments = Scheduler.allAppointmentsByCustomer(CustomerID);
        Appointment A = new Appointment();

        if(customerAppointments.isEmpty()) {
            return A; //no appointments
        }
        else {
            for(Appointment appt : customerAppointments) {

                //if new start is after original start but before original end = problem
                //if new end is after original start but not after original end  = problem
                if(start.isAfter(appt.getStart().toLocalDateTime()) && start.isBefore(appt.getEnd().toLocalDateTime())) {
                   if(appt.getAppointmentID() == AppointmentID) {
                       //appointment being modified is the current appointment - overlaps allowed
                   }
                   else {
                       return appt;
                   }

                }

                if(end.isAfter(appt.getStart().toLocalDateTime()) && !end.isAfter(appt.getEnd().toLocalDateTime())) {
                    if(appt.getAppointmentID() == AppointmentID) {
                        //appointment being modified is the current appointment - overlaps allowed
                    }
                    else {
                        return appt;
                    }

                }

                if(appt.getStart().toLocalDateTime().isEqual(start) || appt.getEnd().toLocalDateTime().isEqual(end)) {
                    if(appt.getAppointmentID() == AppointmentID) {
                        //appointment being modified is the current appointment - overlaps allowed
                    }
                    else {
                        return appt;
                    }

                }
            }
        }
        return A;
    }

    /**
     * Checks to see if there is an appointment in the next fifteen minutes (as of customer's local time). If there is a dialogue is
     * displayed to the user when this function is ran, Detailing Appointment ID, Date and time of upcoming
     * appointment.
     */
    public static void appointmentWithinFifteen() {
        Appointment upcoming = daoAppointment.appointmentWithinFifteenDAO();
        if(upcoming.getAppointmentID() == 0) {
            //Nothing coming up in 15 minutes
            dialogueHandling.informationDialogue(dialogueReturnValues.APPOINTMENT_NOTIFICATION, dialogueReturnValues.NO_APPT_NEXT_15MINUTES);
        }
        else {
            dialogueHandling.appointmentWithinFifteen(upcoming);
        }


    }

    /**
     * Calculates what "now" is from the perspective of the local machine. This is used instead of now()
     * in sql for testing purposes, as this application is tested outside of business hours. Returns a Timestamp
     * that represents the current user's system time, translated into UTC and returned as a timestamp.
     * @return a Timestamp that reflects current system time in UTC.
     */
    public static Timestamp calculateNow() {
        ZonedDateTime currentTime = ZonedDateTime.now().withZoneSameInstant(ZoneOffset.UTC);
        LocalDateTime current = currentTime.toLocalDateTime();
        Timestamp isNow = Timestamp.valueOf(current);
        return isNow;
    }
}
