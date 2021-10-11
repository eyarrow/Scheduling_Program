package scheduler.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    //Lists to store Observable list of customers and Appointments.
    //private static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
    //private static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();
    //public static ObservableList<Country> allCountries = FXCollections.observableArrayList();

    private static TimeZone tz;

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
     * @param user
     * @param success
     */
    public void logLoginAttempt(String user, boolean success) throws IOException {
        //Date date = new Date();
        //DateFormat formatted = new SimpleDateFormat("yyyy-mm-dd");
        //String dateString = formatted.format(date);
        //System.out.println(dateString);

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

    /**
     * Retrieves an list of all Customers
     * @return an observable list
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
     * Adds a customer object
     * @param C is a customer object
     */
    public static void addCustomer(Customer C) {
        addCustomerDAO(C);
    }

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

    public static void deleteCustomer(Customer C) {
        deleteCustomerDAO(C);
    }

    /**
     * Given country_id will return the associated country object.
     * @param country_id
     * @return
     */
    public static Country getCountry(int country_id) {
        return getCountryDAO(country_id);

    }

    public static Division getDivision(int division_id) {
        return getDivisionDAO(division_id);

    }

    /**
     * Updates a customer's record in the application. It is assumed that the data has already been validated.
     * @param C Customer object
     */
    public static void updateCustomer(Customer C) {
        updateCustomerDAO(C);
    }
}
