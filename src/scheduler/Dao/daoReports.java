package scheduler.Dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.model.Appointment;
import scheduler.model.Type;
import scheduler.util.dbOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class daoReports {

    /**
     * Returns the number of appointments sorted by Type of appointment. Result is returned as an Observable
     * list of "Type" objects, which consist of The type description string, and the the aggregate number
     * of appointments of that type.
     * @return Observable list, Type objects
     */
    public static ObservableList<Type> returnTypeAggregatesDAO() {
        ObservableList<Type> aggregate = FXCollections.observableArrayList();
        ResultSet rs;

        for(String type: Type.returnTypes()) {
            String TYPE_SUM_QUERY = String.format("select count(*) from appointments where Type = '%s';", type);
            try {
                rs = dbOperations.dbQuery(TYPE_SUM_QUERY);
                while(rs.next()) {
                    int sum = rs.getInt("count(*)");
                    Type t = new Type(sum, type);
                    aggregate.add(t);
                }
            }
            catch(SQLException e) {
                e.printStackTrace();
            }

        }


        return aggregate;
    }

    /**
     * Returns a list of appointments associated with a specific Contact.
     * @param ContactID Integer, ID of the desired contact.
     * @return An Observable list of appointments associated with the contact. List will be
     * empty if there are no associated appointments.
     */
    public static ObservableList<Appointment> appointmentByContactDAO(int ContactID) {
        ObservableList<Appointment> appointmentsByContact = FXCollections.observableArrayList();
        ResultSet rs;
        String APPOINTMENT_BY_CONTACT = String.format("select * from appointments where Contact_ID = %s;", ContactID);

        try {
            rs = dbOperations.dbQuery(APPOINTMENT_BY_CONTACT);
            while(rs.next()) {
                int id = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
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
                appointmentsByContact.add(A);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        return appointmentsByContact;
    }
}
