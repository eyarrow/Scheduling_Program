package scheduler.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Reports {

    private static ObservableList<String> reportTypes = FXCollections.observableArrayList("Number of Appointments by Type / Month",
            "Contact Schedules", "Somethin' Else");

    public static ObservableList<String> returnListOfReportTypes () {
        return reportTypes;
    }
}
