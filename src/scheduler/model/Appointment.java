package scheduler.model;

import java.time.LocalDateTime;

public class Appointment {
    /**
     * Default Constructor for adding a new Appointment
     * @param appointmentID integer, auto-assigned
     * @param title String, title of the appointment
     * @param description String, description
     * @param location String, location
     * @param contactID integer
     * @param type String, appointment type
     * @param start LocalDateTime, start time
     * @param end LocalDateTime, end time
     * @param customerID int customer id
     * @param userID int user id
     */
    public Appointment(int appointmentID, String title, String description, String location, int contactID, String type, LocalDateTime start, LocalDateTime end, int customerID, int userID) {
        AppointmentID = appointmentID;
        this.title = title;
        this.description = description;
        this.location = location;
        ContactID = contactID;
        this.type = type;
        this.start = start;
        this.end = end;
        CustomerID = customerID;
        UserID = userID;
    }

    /**
     * Constructor for modified appointments
     * @param title String, title of the appointment
     * @param description String, description
     * @param location String, location
     * @param contactID integer
     * @param type String, appointment type
     * @param start LocalDateTime, start time
     * @param end LocalDateTime, end time
     * @param customerID int customer id
     * @param userID int user id
     */
    public Appointment(String title, String description, String location, int contactID, String type, LocalDateTime start, LocalDateTime end, int customerID, int userID) {
        this.title = title;
        this.description = description;
        this.location = location;
        ContactID = contactID;
        this.type = type;
        this.start = start;
        this.end = end;
        CustomerID = customerID;
        UserID = userID;
    }

    private int AppointmentID;
    private String title;
    private String description;
    private String location;
    private int ContactID;
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;
    private int CustomerID;
    private int UserID;


}
