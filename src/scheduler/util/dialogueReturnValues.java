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
    NO_APPOINTMENT_SELECTED("No Appointment selected! Please select an appointment by clicking on it's associated row"),
    START_NOT_VALID("The start date that you have entered is not valid. Please note that appointments can only be scheduled between 8 AM and 10 PM EST"),
    END_NOT_VALID("The end date you have entered is not valid. Please note that appointments can only be scheduled between 8 AM and 10 PM EST"),
    END_BEFORE_START("Please adjust your requested times. An appointment cannot end before it begins."),
    CONTACT_ID_BLANK("Please choose the Contact from the list, it cannot be blank."),
    TYPE_BLANK("Please choose an Appointment type from the list, it cannot be blank."),
    CUSTOMER_BLANK("Please choose a Customer from the list, it cannot be blank."),
    START_TIME_BLANK("Please choose a Start time from the list, it cannot be blank"),
    END_TIME_BLANK("Please choose an End time from the list, it cannot be blank"),
    DATE_BLANK("Please choose a Date from the list, it cannot be blank."),

    /** Notifications **/
    APPOINTMENT_NOTIFICATION("Appointment Notification"),
    APPT_NEXT_15MINUTES("You have an appointment coming up in the next 15 minutes"),
    NO_APPT_NEXT_15MINUTES("You do not have any appointments in the next 15 minutes"),
    CUSTOMER_DELETED_HEADER("Customer deleted"),
    CUSTOMER_DELETED_BODY("The customer has been deleted from the application successfully."),
    APPT_ADDED_SUCCESSFULLY("The Appointment has been added!"),

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
