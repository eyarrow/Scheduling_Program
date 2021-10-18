package scheduler.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Type {
    private String typeDescription;
    private int numberOfOccurences;

    private static ObservableList <String> AppointmentTypes = FXCollections.observableArrayList("Planning Session", "De-Briefing", "One-on-One", "New Customer Meeting", "General Type");

    public Type() {
        this.numberOfOccurences = 0;
        this.typeDescription = " ";
    }

    public Type(int numberOfOccurences, String typeDescription) {
        this.numberOfOccurences = numberOfOccurences;
        this.typeDescription = typeDescription;
    }

    @Override
    public String toString() {
        return this.typeDescription;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public int getNumberOfOccurences() {
        return numberOfOccurences;
    }

    public void setNumberOfOccurences(int numberOfOccurences) {this.numberOfOccurences = numberOfOccurences;
    }

    public static ObservableList<String> returnTypes() {
        return AppointmentTypes;
    }
}
