package scheduler.Dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.model.Appointment;
import scheduler.model.Type;
import scheduler.util.dbOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.*;

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

    public static int returnNumberOfAppointmentsTodayDAO() {
        //from now to end of business day
        //Create end of business day timestamp
        LocalDate today = LocalDate.now();
        LocalTime endOfDay = LocalTime.of(22, 0);
        ZonedDateTime Z = ZonedDateTime.of(today, endOfDay, ZoneId.systemDefault());
        ZonedDateTime Z_UTC = Z.withZoneSameInstant(ZoneOffset.UTC);

        LocalDateTime end = Z_UTC.toLocalDateTime();
        Timestamp endTime = Timestamp.valueOf(end);
        String APPOINTMENTS_TODAY = String.format("select count(*) from appointments where Start between now() and %s;", endTime);
        ResultSet rs;
        int count = 0;

        try {
            rs = dbOperations.dbQuery(APPOINTMENTS_TODAY);
            while(rs.next()) {
                count = rs.getInt("count(*)");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return count;

    }

    public static int returnNumberOfAppointmentsTomorrowDAO() {
        //number of appointments from 8:00 am - 10:00 pm EST following business day.
        return 0;
    }

    public static int returnNumberOfAppointmentsThisWeek() {
        //returns number of appointments over the next 7 days
        return 0;
    }


}
