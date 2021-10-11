package scheduler.Dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.model.Appointment;
import scheduler.model.Contact;
import scheduler.util.dbOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Class that provides functionality on the persistence layer for the "Appointment" class where business logic is implemented.
 */
public abstract class daoAppointment {
    /**
     * Returns all Contacts to the application
     *
     * @return an observable list
     */
    public static ObservableList<Contact> getAllContactsDAO() throws SQLException {
        String ALL_CONTACTS = "SELECT * FROM contacts;";
        ResultSet rs;
        ObservableList<Contact> cList = FXCollections.observableArrayList();
        Contact C;

        try {
            rs = dbOperations.dbQuery(ALL_CONTACTS);
            while (rs.next()) {
                int id = rs.getInt("Contact_ID");
                String name = rs.getString("Contact_Name");
                C = new Contact(id, name);
                cList.add(C);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cList;

    }

    public static ObservableList<Appointment> getAllAppointmentsDAO() {
        String GET_APPOINTMENTS = "select * from appointments;";
        ResultSet rs;
        ObservableList<Appointment> cList = FXCollections.observableArrayList();

        try {
            rs = dbOperations.dbQuery(GET_APPOINTMENTS);
            while(rs.next()) {
                int id = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                int ContactID = rs.getInt("Contact_ID");
                String type = rs.getString("Type");
                Timestamp start = rs.getTimestamp("Start");
                Timestamp end = rs.getTimestamp("End");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}