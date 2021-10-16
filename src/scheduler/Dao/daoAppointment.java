package scheduler.Dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.model.Appointment;
import scheduler.model.Contact;
import scheduler.model.TimeManagement;
import scheduler.util.dbOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;

/**
 * Class that provides functionality on the persistence layer for the "Appointment" class where business logic is implemented.
 */
public abstract class daoAppointment {
    /**
     * Returns all Contacts to the application
     *
     * @return an observable list
     */
    public static ObservableList<Contact> getAllContactsDAO() {
        String ALL_CONTACTS = "SELECT * FROM contacts;";
        ResultSet rs;
        ObservableList<Contact> aList = FXCollections.observableArrayList();
        Contact C;

        try {
            rs = dbOperations.dbQuery(ALL_CONTACTS);
            while (rs.next()) {
                int id = rs.getInt("Contact_ID");
                String name = rs.getString("Contact_Name");
                C = new Contact(id, name);
                aList.add(C);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aList;

    }

    /**
     * Returns all appointments that currently exist
     * @return
     */
    public static ObservableList<Appointment> getAllAppointmentsDAO() {
        String GET_APPOINTMENTS = "select * from appointments;";
        ResultSet rs;
        ObservableList<Appointment> aList = FXCollections.observableArrayList();

        try {
            rs = dbOperations.dbQuery(GET_APPOINTMENTS);
            while(rs.next()) {
                int id = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                int ContactID = rs.getInt("Contact_ID");
                String type = rs.getString("Type");
                Timestamp start_time = rs.getTimestamp("Start");
                LocalDateTime start = start_time.toLocalDateTime();
                ZonedDateTime startZoned = ZonedDateTime.of(start, ZoneId.systemDefault());
                Timestamp end_time = rs.getTimestamp("End");
                LocalDateTime end = end_time.toLocalDateTime();
                ZonedDateTime endZoned = ZonedDateTime.of(end, ZoneId.systemDefault());
                int CustomerID = rs.getInt("Customer_ID");
                int UserID = rs.getInt("User_ID");

                Appointment A = new Appointment(id, title, description, location, ContactID, type, startZoned, endZoned, CustomerID, UserID);
                aList.add(A);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aList;
    }

    /**
     * Returns a contact object, given their ID
     * @param id Integer, ContactID
     * @return Corresponding Contact object
     */
    public static Contact getContactByIDDAO(int id) {
        String RETURN_CONTACT = String.format("SELECT Contact_ID, Contact_Name FROM contacts WHERE Contact_ID = %x;", id);
        ResultSet rs;
        Contact C = new Contact(0, "NULL");

        try {
            rs = dbOperations.dbQuery(RETURN_CONTACT);
            while(rs.next()) {
                int Cid = rs.getInt("Contact_ID");
                String CName = rs.getString("Contact_Name");
                C.setContactID(Cid);
                C.setContactName(CName);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return C;
    }

    /**
     * Adds an appointment to the database. Assumes validation has been completed and that this is
     * not a duplicate of another appointment.
     * @param A appointment object.
     */
    public static void addAppointmentDAO(Appointment A) {
        //Convert to UTC time
        ZonedDateTime startA = A.getStart().withZoneSameInstant(ZoneOffset.UTC);
        ZonedDateTime endA = A.getEnd().withZoneSameInstant(ZoneOffset.UTC);

        //Convert to Local Time
        LocalDateTime start =startA.toLocalDateTime();
        LocalDateTime end = endA.toLocalDateTime();

        //Convert to Timestamp
        Timestamp start_time = Timestamp.valueOf(start);
        Timestamp end_time = Timestamp.valueOf(end);

        String timeStart = start_time.toString();
        String timeEnd = end_time.toString();

        //System.out.println("Start time is " + timeStart);
        //System.out.println("End time is " + timeEnd);

        String addAppointment = String.format("INSERT INTO appointments (Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_ID)\n" +
                "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %s, %s, %s);", A.getTitle(), A.getDescription(), A.getLocation(), A.getType(), timeStart, timeEnd, A.getCustomerID(), A.getUserID(), A.getContactID());

        dbOperations.dbUpdate(addAppointment);




    }

}