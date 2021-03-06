package scheduler.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import scheduler.model.Appointment;
import scheduler.model.Customer;
import scheduler.model.Scheduler;

import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Displays alert, error, and confirmation dialogues to the end user. Does some logical error checking.
 */
public abstract class dialogueHandling {

    /**
     * Used to display basic alert and confirmation dialogues to the user. Errors and confirmation
     * messages are displayed in the type of dialogue indicated by the boolean parameter. This function
     * assumes that the message is a single string, that does not require formatting.
     *
     * @param error a true value will display an "Error" dialogue. A false value will result
     *              in a "Confirmation" dialogue being displayed.
     * @param code  an enum value that will be used to display the correct feedback in the dialogue
     *              box. It is used to insert the appropriate string. Parameter must be from dialogueReturnValues.
     * @return boolean is set to true if the user responded with "Ok" in the confirmation dialogue. A true
     * value indicates that the user was passed a confirmation dialogue, and pressed the button to proceed.
     * Both error dialogue and cancel responses for a confirmation dialogue will return a false boolean.
     */
    public static boolean displayDialogue(boolean error, dialogueReturnValues code) {
        if (error) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(code.toString());
            alert.showAndWait();
            return false;
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, code.toString());
            alert.setTitle("Please confirm?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                return true;
            } else {
                return false;
            }
        }
    }


    /**
     * Displays an Information dialogue. The pop-up dialogue uses a descriptive header in combination
     * with the actual end user response.
     *
     * @param header  reflects the overall subject of the dialogue. Accepts a dialogueReturnValues enum value.
     * @param content informational dialogue content. Accepts a dialogueReturnValues enum value.
     * @return
     */
    public static boolean informationDialogue(dialogueReturnValues header, dialogueReturnValues content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setHeaderText(header.toString());
        alert.setContentText(content.toString());

        alert.showAndWait().ifPresent((response -> {
            if (response == ButtonType.OK) {

            }
        }));

        return true;
    }


    /**
     * Provides a confirmation dialogue to the user, with a header.
     *
     * @param header  is a String that is topical to the confirmation
     * @param message is a String that queries the user as to whether the operation should be continued.
     * @return true if the user confirms, false if they click cancel
     */
    public static boolean confirmationDialogue(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setHeaderText(header);
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * Does rudimentary authentication for login. Checks to make sure neither user name or password are null.
     * Calls the logLoginAttempt function to log the login attempt in the persistent log.
     *
     * @param username String, user name entered by the user.
     * @param password String, password entered by the user.
     * @return true if the user name and password pass initial validity checks. False if they do not.
     * @throws IOException
     */
    public static boolean checkAuthentication(String username, String password) throws IOException {
        //checks to make sure user and password are not null. Authenticates if values are present
        //for both fields.
        ResourceBundle rb = ResourceBundle.getBundle("scheduler/Nat", Locale.getDefault());
        if (username.isEmpty() || password.isEmpty()) {
            if(Locale.getDefault().getLanguage().equals("fr")) {
                String err = rb.getString("Pleasemakesureallfieldsarepopulated");
                dialogueHandling.validationDialogue(err);
            }
            else {
                dialogueHandling.displayDialogue(true, dialogueReturnValues.NO_CONTENT);
            }

            Scheduler sched = new Scheduler();
            if (!username.isEmpty()) {
                sched.logLoginAttempt(username, false);
            } else {
                sched.logLoginAttempt("Unknown", false);
            }

            return false;
        }
        return true;
    }


    /**
     * Solicits feedback from the customer on how to proceed. See: confirmationDialogue if  a header is needed.
     *
     * @param feedback is a String provided by the calling function
     * @return a boolean true value if the user clicks "Ok" false if they click cancel
     */
    public static boolean confirmationDialogue(String feedback) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, feedback);
        alert.setTitle("Please confirm?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Displays an error dialogue that requires the user to acknowledge the message before continuing.
     * This is used specifically for issues were errors are more complex, and built strings need
     * to provide additional information back to the user.
     *
     * @param errorList is a string that is presented to the user.
     */
    public static void validationDialogue(String errorList) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(errorList);
        alert.showAndWait();

    }


    /**
     * Provides validation that information entered for a customer meets business standards (not null)
     *
     * @param name    String, name of the customer
     * @param address String, address
     * @param postal  String, postal code
     * @param phone   String, phone number
     * @return true if the values entered are valid, false if they do not pass validation
     */
    public static boolean validateCustomer(String name, String address, String postal, String phone) {
        String errorMessage = new String("Please resolve the following issues: \n");
        boolean valid = true;
        if (name.isEmpty()) {
            String str1 = new String(errorMessage);
            errorMessage = str1.concat("* Please enter the full name of the customer \n");
            valid = false;
        }
        if (address.isEmpty()) {
            String str1 = new String(errorMessage);
            errorMessage = str1.concat("* Please enter the full address of the customer \n");
            valid = false;
        }
        if (postal.isEmpty()) {
            String str1 = new String(errorMessage);
            errorMessage = str1.concat("* Please enter the full postal code \n");
            valid = false;
        }
        if (phone.isEmpty()) {
            String str1 = new String(errorMessage);
            errorMessage = str1.concat("* Please enter the full phone number \n");
            valid = false;
        }

        if (!valid) {
            validationDialogue(errorMessage);
            return valid;
        } else {
            return valid;
        }


    }


    /**
     * Prints a dialogue that confirms that a customer has been added
     *
     * @param C Represents a new customer record
     */
    public static void confirmCustomerAdded(Customer C) {
        String Header = "Customer Added!";
        String CUSTOMER_ADDED = "You have successfully added the following customer: \n" +
                "Name: " + C.getName() + " \n" +
                "Address: " + C.getAddress() + ", " + C.getPostalCode() + " \n" +
                "Phone: " + C.getPhoneNumber() + " \n" +
                "Country ID: " + Scheduler.getCountry(C.getCountryID()).getName() + " \n" +
                "Division ID: " + Scheduler.getDivision(C.getDivisionID()).getName() + " \n";

        confirmationDialogue(Header, CUSTOMER_ADDED);


    }


    /**
     * Prints a dialogue that confirms that a customer has been updated
     *
     * @param C Updated customer object
     */
    public static void confirmCustomerUpdated(Customer C) {
        String Header = "Customer Updated!";

        String CUSTOMER_UPDATED = "You have successfully Updated the following customer: \n" +
                "Name: " + C.getName() + " \n" +
                "Address: " + C.getAddress() + ", " + C.getPostalCode() + " \n" +
                "Phone: " + C.getPhoneNumber() + " \n" +
                "Country ID: " + Scheduler.getCountry(C.getCountryID()).getName() + " \n" +
                "Division ID: " + Scheduler.getDivision(C.getDivisionID()).getName() + " \n";

        confirmationDialogue(Header, CUSTOMER_UPDATED);


    }


    /**
     * Prints a dialogue that confirms whether or not the user truly wants to delete a customer record.
     *
     * @param C The customer object that is ready to be deleted
     * @return true, if the end user confirmed the deletion. False if these chose "Cancel".
     */
    public static boolean confirmDeletionCustomer(Customer C) {
        String CONFIRM_DELETION = "Are you sure you want to delete the following customer? This action is not reversible, and all appointments associated with this customer will be deleted! \n" +
                "Name: " + C.getName() + " \n" +
                "Address: " + C.getAddress() + ", " + C.getPostalCode() + " \n" +
                "Phone: " + C.getPhoneNumber() + " \n" +
                "Country ID: " + Scheduler.getCountry(C.getCountryID()).getName() + " \n" +
                "Division ID: " + Scheduler.getDivision(C.getDivisionID()).getName() + " \n";

        if (confirmationDialogue(CONFIRM_DELETION)) {
            return true;
        }

        return false;
    }

    /**
     * Runs validation on appointment fields to make sure they are not empty. If they are, a custom
     * error message is returned to the user, including the specifics of what needs to be updated
     * @param title String, title of the appointment
     * @param description String, description of the appointment
     * @param location String, location of the appointment
     * @return
     */
    public static boolean validateAppointment(String title, String description, String location) {
        boolean valid = true;
        String errMessage = "Please resolve the following issues: \n";
        if (title.isEmpty()) {
            String strNew = errMessage;
            errMessage = strNew.concat("* Please enter a title \n");
            valid = false;
        }
        if (description.isEmpty()) {
            String strNew = errMessage;
            errMessage = strNew.concat("* Please enter a description \n");
            valid = false;
        }
        if (location.isEmpty()) {
            String strNew = errMessage;
            errMessage = strNew.concat("* Please enter a location \n");
            valid = false;
        }

        if (!valid) {
            validationDialogue(errMessage);
        }

        return valid;
    }

    /**
     * Displays a dialogue that confirms that an appointment has been added successfully
     *
     * @param A, The appointment that has been added.
     */
    public static void confirmAppointmentAdded(Appointment A) {
        String header = (dialogueReturnValues.APPT_ADDED_SUCCESSFULLY).toString();
        String APPOINTMENT_ADDED_DETAIL = "You have successfully added the following appointment: \n" +
                "Title: " + A.getTitle() + "\n" +
                "Description: " + A.getDescription() + "\n" +
                "Location: " + A.getLocation() + "\n" +
                "Contact Name: " + A.getContactName() + "\n" +
                "Customer Name: " + Scheduler.returnCustomerName(A.getCustomerID()) + "\n" +
                "Start Time: " + A.getFormattedStart() + "\n" +
                "End Time: " + A.getFormattedEnd() + "\n";

        dialogueHandling.confirmationDialogue(header, APPOINTMENT_ADDED_DETAIL);

    }

    /**
     * Requests confirmation from the user that they would like to modify an appointment
     * @param A an appointment
     * @return true if the user chooses to proceed, false, if they choose to cancel
     */
    public static boolean confirmAppointmentModification(Appointment A) {

        String CONFIRM_MODIFICATION = "Please confirm that you would like to make the following changes? \n" +
                "Title: " + A.getTitle() + "\n" +
                "Description: " + A.getDescription() + "\n" +
                "Location: " + A.getLocation() + "\n" +
                "Contact Name: " + A.getContactName() + "\n" +
                "Customer Name: " + Scheduler.returnCustomerName(A.getCustomerID()) + "\n" +
                "Start Time: " + A.getFormattedStart() + "\n" +
                "End Time: " + A.getFormattedEnd() + "\n";
        if (confirmationDialogue(CONFIRM_MODIFICATION)) {
            return true;
        }

        return false;

    }

    /**
     * Dialogue to confirm whether the user would like to proceed with deleting an appointment record
     *
     * @param A Appointment object to delete
     * @return boolean true if the user clicks "Ok", false, if they click on "Cancel"
     */
    public static boolean confirmAppointmentDeletion(Appointment A) {
        String DELETION_CONFIRMATION = "Please confirm if you would like to continue and delete the following record? \n" +
                "Appointment ID: " + A.getAppointmentID() + "\n" +
                "Type: " + A.getType() + "\n" +
                "Title: " + A.getTitle() + "\n" +
                "Description: " + A.getDescription() + "\n" +
                "Location: " + A.getLocation() + "\n" +
                "Contact Name: " + A.getContactName() + "\n" +
                "Customer Name: " + Scheduler.returnCustomerName(A.getCustomerID()) + "\n" +
                "Start Time: " + A.getFormattedStart() + "\n" +
                "End Time: " + A.getFormattedEnd() + "\n";
        if (confirmationDialogue(DELETION_CONFIRMATION)) {
            return true;
        }
        return false;
    }

    /**
     * Dialogue to inform the user that they are attempting to schedule an appointment for a customer
     * that conflicts with an appointment that is already existing.
     * @param existing Details of current appointment
     * @param proposed Details of the new proposed appointment
     */
    public static void appointmentSchedulingConflict(Appointment existing, Appointment proposed) {
        String SCHEDULING_CONFLICT = String.format("There is a conflict between the appointment you are trying " +
                        "to schedule with %s, and an already existing appointment. Please address this " +
                        "before continuing: \n" +
                        "Existing Appointment: \n" +
                        "* Appointment ID: %s \n" +
                        "* Title: %s \n" +
                        "* Start Time: %s \n" +
                        "* End Time: %s \n" + "\n" +
                        "Proposed Appointment: \n" +
                        "* Title: %s \n" +
                        "* Start Time: %s \n" +
                        "* End Time: %s \n", Scheduler.returnCustomerName(existing.getCustomerID()), existing.getAppointmentID(),
                existing.getTitle(), existing.getFormattedStart(), existing.getFormattedEnd(),
                proposed.getTitle(), proposed.getFormattedStart(), proposed.getFormattedEnd());

        validationDialogue(SCHEDULING_CONFLICT);
    }


    /**
     * Displays a dialogue to the user when there is another appointment starting within 15 minutes.
     *
     * @param upcomingAppointment Appointment object, upcoming appointment
     */
    public static void appointmentWithinFifteen(Appointment upcomingAppointment) {
        String HEADER = "Appointment coming up in the next 15 minutes!";
        String APPOINTMENT_DETAIL = String.format("An Appointment with the Title %s, is coming up soon! Here are the details: \n" +
                        "* Appointment ID: %s \n" +
                        "* Start Date / Time: %s \n" +
                        "* End Date / Time: %s \n", upcomingAppointment.getTitle(),
                upcomingAppointment.getAppointmentID(), upcomingAppointment.getFormattedStart(), upcomingAppointment.getFormattedEnd());

        confirmationDialogue(HEADER, APPOINTMENT_DETAIL);
    }

}
