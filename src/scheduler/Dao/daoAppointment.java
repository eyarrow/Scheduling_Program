package scheduler.Dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.model.Contact;
import scheduler.util.dbOperations;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class that provides functionality on the persistence layer for the "Appointment" class where business logic is implemented.
 */
public abstract class daoAppointment {
    /**
     * Returns all Contacts to the application
     * @return an observable list
     */
    public static ObservableList<Contact> getAllContactsDAO() throws SQLException {
        String ALL_CONTACTS = "SELECT * FROM contacts;";
        ResultSet rs;
        ObservableList<Contact> cList = FXCollections.observableArrayList();
        Contact C;

        try {
            rs = dbOperations.dbQuery(ALL_CONTACTS);
            while(rs.next()) {
                int id = rs.getInt("Contact_ID");
                String name = rs.getString("Contact_Name");
                C = new Contact(id, name);
                cList.add(C);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return cList;

    }

}
