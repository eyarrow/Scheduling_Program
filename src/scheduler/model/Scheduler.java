package scheduler.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.Dao.daoAppointment;
import scheduler.util.dialogueHandling;
import scheduler.util.dialogueReturnValues;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

import static scheduler.Dao.daoCustomer.*;
import static scheduler.Dao.loginAuthentication.authenticateUser;

/**
 * The Scheduler object manages business layer functionality for the overall application.
 */
public class Scheduler {
    //Persistent Observable Lists and data members
    private static ObservableList <String> AppointmentTypes = FXCollections.observableArrayList("Planning Session", "De-Briefing", "One-on-One", "New Customer Meeting", "General Type");
    private static TimeZone tz;
    private static ObservableList <String> times = FXCollections.observableArrayList();
    //Variable to store User ID:
    private static int UserID;

    /**
     * Sets the value of user id to the user who is logged in.
     * @param user Integer, UserId
     */
    public static void setUserID(int user) {
        UserID = user;
    }

    //Login Functions
    /**
     * Authenticates a user based on their username and password. Uses the DAO package to handle
     * backend operations. Displays Appointment alerts or error messaging as appropriate.
     * @param username is the username for login
     * @param password is the password for login
     * @return boolean is true if the user / password combination authenticates. Returns false if
     * it does not.
     * @throws SQLException in case of error
     */
    public boolean loginToApplication (String username, String password) throws SQLException, IOException {
        boolean success = authenticateUser(username, password);

        if(success) {
            dialogueHandling.informationDialogue(dialogueReturnValues.APPOINTMENT_NOTIFICATION, dialogueReturnValues.NO_APPT_NEXT_15MINUTES);
            logLoginAttempt(username, true);
            return true;
        }
        else {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.WRONG_PASSWORD);
            logLoginAttempt(username, false);
            return false;

        }
    }

    /**
     * Writes to the log file whenever a login attempt is made. Writes the following to the log:
     * Username, date and timestamp, and whether or not the login attempt was successful.
     * Username is recorded as "Unknown" if the username field was left blank during the login attempt.
     * Called by checkAuthentication in the dialogueHandling class.
     * @param user the user name
     * @param success a boolean that represents whether a login attempt was successful. True = Successful attempt.
     *                False = Unsuccessful Login attempt.
     */
    public void logLoginAttempt(String user, boolean success) throws IOException {

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();


        String result;
        if(success) {
            result = "Successful";
        }
        else {
            result = "Unsuccessful";
        }
        FileWriter authenticationLog = new FileWriter("login_activity.txt", true);
        PrintWriter pw = new PrintWriter(authenticationLog);
        pw.format("User: '%s', made a login attempt that was %s on %s at %s user's system time. ", user, result, date, time);
        pw.println();
        pw.close();
    }

    //Customer Functions
    /**
     * Retrieves an list of all Customers
     * @return an observable list of all customers
     */
    public static ObservableList<Customer> getAllCustomers() {
        try {
            return getAllCustomersDAO();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    /**
     * Adds a new customer.
     * @param C is the customer object to be added.
     */
    public static void addCustomer(Customer C) {
        addCustomerDAO(C);
    }

    /**
     * Deletes a Customer.
     * @param C is the customer object to be deleted.
     */
    public static void deleteCustomer(Customer C) {
        deleteCustomerDAO(C);
    }


    /**
     * Updates a customer's record in the application. It is assumed that the data has already been validated.
     * @param C Customer object
     */
    public static void updateCustomer(Customer C) {
        updateCustomerDAO(C);
    }



    //Countries & Divisions
    /**
     * Returns a list of all Countries
     * @return Observable list of all countries
     */
    public static ObservableList<Country> getAllCountries() {
        return getAllcountriesDAO();
    }

    /**
     * Returns a list of division id's based on country id
     * @param country_id for country for which division is desired
     * @return Observable list of divisions
     */
    public static ObservableList<Division> getDivision(Country country_id) {
        return getDivisionDAO(country_id);
    }


    /**
     * Given country_id will return the associated country object.
     * @param country_id
     * @return
     */
    public static Country getCountry(int country_id) {
        return getCountryDAO(country_id);

    }

    /**
     * Given a Division ID, will return the associated Division object
     * @param division_id
     * @return
     */
    public static Division getDivision(int division_id) {
        return getDivisionDAO(division_id);

    }


    //Appointments

    /**
     * Returns all contacts back to the UI
     * @return Observable List
     */
    public static ObservableList<Contact> getAllContacts() {
        return daoAppointment.getAllContactsDAO();
    }

    /**
     * Returns all Appointments to the UI
     * @return Observable list of all appointments.
     */
    public static ObservableList<Appointment> getAllAppointments() {
        return daoAppointment.getAllAppointmentsDAO();
    }

    /**
     * Returns a Contact object, given their Contact ID
     * @param id, Integer contact ID
     * @return Contact object
     */
    public static Contact getContactByID(int id) {
        return daoAppointment.getContactByIDDAO(id);
    }

    /**
     * Returns a list of allowable appointment types
     * @return Observable list of appointment types
     */
    public static ObservableList<String> returnAppointmentTypes() {
        return AppointmentTypes;
    }


    /**
     * Populates the time values for the program. Is only required to be run once.
     */
    public static void populateTimes() {
        ObservableList<String> concatTimes = FXCollections.observableArrayList();
      concatTimes.addAll("00", "01", "02", "03,", "04", "05", "06", "07", "08", "09",
      "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24");

        for(String hours : concatTimes) {
            String time1 = hours + ":00";
            String time2 = hours + ":15";
            String time3 = hours + ":30";
            String time4 = hours + ":45";
            times.addAll(time1, time2, time3, time4);
        }
    }

    /**
     * Returns the list of times for appointment dropdown boxes
     * @return Observable list of times.
     */
    public static ObservableList<String> returnTimes() {
        return times;
    }
}
