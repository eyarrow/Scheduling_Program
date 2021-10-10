package scheduler.util;

/**
 * This class contains enumerated values that correspond to Strings that will be displayed to the
 * end user in Alert and Confirmation dialogue boxes. The .toString() method is overloaded so that it
 * returns the correct string corresponding to the error code.
 */
public enum dialogueReturnValues {
    /** Error messages **/
    WRONG_PASSWORD("The username and password combination were not found. Please try again."),
    NO_CONTENT("Please make sure all fields are populated."),
    COUNTRY_CODE_BLANK("Please choose the country, it cannot be blank."),
    DIVISION_CODE_BLANK("Please choose the Division, it cannot be blank. "),
    NO_CUSTOMER_SELECTED("No customer selected! Please select a customer by clicking on their associated row."),

    /** Notifications **/
    APPOINTMENT_NOTIFICATION("Appointment Notification"),
    APPT_NEXT_15MINUTES("You have an appointment coming up in the next 15 minutes"),
    NO_APPT_NEXT_15MINUTES("You do not have any appointments in the next 15 minutes"),
    CUSTOMER_DELETED_HEADER("Customer deleted"),
    CUSTOMER_DELETED_BODY("The customer has been deleted from the application successfully."),

    /** Confirmations **/
    APPLICATION_EXIT("Are you sure you would like to exit the program?");

    private String message;

    /**
     * Constructor for the dialogueReturnValues enumeration class that accepts a String as a parameter.
     * The String corresponds to a notification, error, or confirmation message that will be displayed
     * to the end user.
     * @param mess is the error, confirmation or notification message.
     */
    private dialogueReturnValues(String mess) {
        this.message = mess;
    }

    /**
     * Overrides the .toString() function, so that it returns the string associated with the enumeration.
     * @return the string associated with the enum code.
     */
    @Override
    public String toString() {
        return this.message;
    }
}
