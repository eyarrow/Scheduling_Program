package scheduler.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Type {
    private static String typeDescription;
    private static int numberOfOccurences;

    private static ObservableList <String> AppointmentTypes = FXCollections.observableArrayList("Planning Session", "De-Briefing", "One-on-One", "New Customer Meeting", "General Type");

    public Type() {
        this.numberOfOccurences = 0;
        this.typeDescription = " ";
    }

    public Type(int numberOfOccurences, String typeDescription) {
        this.numberOfOccurences = numberOfOccurences;
        this.typeDescription = typeDescription;
    }

    public static String getTypeDescription() {
        return typeDescription;
    }

    public static void setTypeDescription(String typeDescription) {
        Type.typeDescription = typeDescription;
    }

    public static int getNumberOfOccurences() {
        return numberOfOccurences;
    }

    public static void setNumberOfOccurences(int numberOfOccurences) {
        Type.numberOfOccurences = numberOfOccurences;
    }

    public static ObservableList<String> returnTypes() {
        return AppointmentTypes;
    }
}
