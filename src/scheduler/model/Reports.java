package scheduler.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.Dao.daoReports;

public class Reports {

    private static ObservableList<String> reportTypes = FXCollections.observableArrayList("Number of Appointments by Type / Month",
            "Contact Schedules", "Somethin' Else");

    public static ObservableList<String> returnListOfReportTypes () {
        return reportTypes;
    }

    public static ObservableList<Type> returnTypeAggregates() {

        //return daoReports.returnTypeAggregatesDAO();
        ObservableList<Type> results = daoReports.returnTypeAggregatesDAO();

        for(Type items : results) {
            System.out.println(items.toString());
        }
        return results;
    }

    /**
     * Returns a list of appointments associated with a specific Contact.
     * @param ContactID Integer, ID of the desired contact.
     * @return An Observable list of appointments associated with the contact. List will be empty if
     * there are no associated appointments.
     */
    public static ObservableList<Appointment> appointmentByContact(int ContactID) {
        return daoReports.appointmentByContactDAO(ContactID);
    }
}
