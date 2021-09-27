package scheduler.util;

/**
 * This class contains enumerated values that correspond to Strings that will be displayed to the
 * end user in Alert and Confirmation dialogue boxes. The .toString() method is overloaded so that it
 * returns the correct string corresponding to the error code.
 */
public enum dialogueReturnValues {
    WRONG_PASSWORD("The username and password combination were not found. Please try again."),
    NO_CONTENT("Please make sure all fields are populated."),
    APPOINTMENT_NOTIFICATION("Appointment Notification"),
    APPT_NEXT_15MINUTES("You have an appointment coming up in the next 15 minutes"),
    NO_APPT_NEXT_15MINUTES("You do not have any appointments in the next 15 minutes");

    private String message;

    //Constructor for enum with a string parameter
    private dialogueReturnValues(String mess) {
        this.message = mess;
    }

    //override the .tostring() function for this enum
    @Override
    public String toString() {
        return this.message;
    }
}
