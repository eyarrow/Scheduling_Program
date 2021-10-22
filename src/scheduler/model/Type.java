package scheduler.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class to manage a "Type" object
 */
public class Type {
    private String typeDescription;
    private int numberOfOccurences;

    private static ObservableList <String> AppointmentTypes = FXCollections.observableArrayList("Planning Session", "De-Briefing", "One-on-One", "New Customer Meeting", "General Type");

    /**
     * Constructor for a null object
     */
    public Type() {
        this.numberOfOccurences = 0;
        this.typeDescription = " ";
    }

    /**
     * Constructor to create a type object
     * @param numberOfOccurences Number of occurences of the "type" of appointment
     * @param typeDescription A String of the types description
     */
    public Type(int numberOfOccurences, String typeDescription) {
        this.numberOfOccurences = numberOfOccurences;
        this.typeDescription = typeDescription;
    }

    /**
     * Overriding .toString() to return the String representing the type
     * @return the type as a human readable string
     */
    @Override
    public String toString() {
        return this.typeDescription;
    }


    /**
     * Return type description
     * @return
     */
    public String getTypeDescription() {
        return typeDescription;
    }

    /**
     * Set type description
     * @param typeDescription
     */
    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    /**
     * Get number of occurences of a type
     * @return
     */
    public int getNumberOfOccurences() {
        return numberOfOccurences;
    }

    /**
     * Set number of occurences of a type
     * @param numberOfOccurences
     */
    public void setNumberOfOccurences(int numberOfOccurences) {this.numberOfOccurences = numberOfOccurences;
    }

    /**
     * Return a list of types
     * @return Observable list of Types - Strings.
     */
    public static ObservableList<String> returnTypes() {
        return AppointmentTypes;
    }
}
