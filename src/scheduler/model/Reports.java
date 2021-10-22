package scheduler.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.Dao.daoReports;

public class Reports {

    private static ObservableList<String> reportTypes = FXCollections.observableArrayList("Number of Appointments by Type / Month",
            "Contact Schedules");

    private static ObservableList<String> months = FXCollections.observableArrayList("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December");

    public static ObservableList<String> returnListOfReportTypes () {
        return reportTypes;
    }

    public static ObservableList<Type> returnTypeAggregates(String month) {

        //return daoReports.returnTypeAggregatesDAO();
        ObservableList<Type> results = daoReports.returnTypeAggregatesDAO(month);

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


    /**
     * Returns the number of appointments that are scheduled for the next business day.
     * @return Integer, sum of appointments.
     */
    public static int returnNumberOfAppointmentsTomorrow() {
        return daoReports.returnNumberOfAppointmentsTomorrowDAO();
    }


    /**
     * Returns the sum of appointments that's start time falls in the next 7 calendar days.
     * @return Integer, number of appointments.
     */
    public static int returnNumberOfAppointmentsThisWeekDAO() {
        return daoReports.returnNumberOfAppointmentsThisWeekDAO();
    }

    /**
     * Returns a list of the 12 months of the year.
     * @return Observable list of months.
     */
    public static ObservableList<String> returnMonths() {
        return months;
    }
}
