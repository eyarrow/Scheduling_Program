package scheduler.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.Dao.daoReports;

public class Reports {

    private static ObservableList<String> reportTypes = FXCollections.observableArrayList("Number of Appointments by Type / Month",
            "Contact Schedules");

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


    /**
     * Returns the sum of appointments that have start times that fall between the current time, and the end
     * of the current business day.
     * @return Integer, number of appointments left in the business day.
     */
    public static int returnNumberOfAppointmentsToday() {
        return daoReports.returnNumberOfAppointmentsTodayDAO();
    }


    public static int returnNumberOfAppointmentsTomorrow() {
        return daoReports.returnNumberOfAppointmentsTomorrowDAO();
    }
}
