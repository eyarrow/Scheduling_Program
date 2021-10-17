package scheduler.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import scheduler.model.Appointment;
import scheduler.model.Customer;
import scheduler.model.Scheduler;

import java.io.IOException;
import java.util.Optional;

/**
 * Displays alert, error, and confirmation dialogues to the end user. Does some logical error checking.
 */
public abstract class dialogueHandling {

    /**
     *
     * Used to display basic alert and confirmation dialogues to the user. Errors and confirmation
     * messages are displayed in the type of dialogue indicated by the boolean parameter. This function
     * assumes that the message is a single string, that does not require formatting.
     * @param error a true value will display an "Error" dialogue. A false value will result
     *              in a "Confirmation" dialogue being displayed.
     * @param code  an enum value that will be used to display the correct feedback in the dialogue
     *              box. It is used to insert the appropriate string. Parameter must be from dialogueReturnValues.
     * @return boolean is set to true if the user responded with "Ok" in the confirmation dialogue. A true
     * value indicates that the user was passed a confirmation dialogue, and pressed the button to proceed.
     * Both error dialogue and cancel responses for a confirmation dialogue will return a false boolean.
     *
     */
    public static boolean displayDialogue(boolean error, dialogueReturnValues code) {
        if(error) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(code.toString());
            alert.showAndWait();
            return false;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, code.toString());
            alert.setTitle("Please confirm?");
            Optional<ButtonType> result = alert.showAndWait();

            if(result.isPresent() && result.get() == ButtonType.OK) {
                return true;
            }
            else {
                return false;
            }
        }
}


    /**
     * Displays an Information dialogue. The pop-up dialogue uses a descriptive header in combination
     * with the actual end user response.
     * @param header reflects the overall subject of the dialogue. Accepts a dialogueReturnValues enum value.
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
     * @param header is a String that is topical to the confirmation
     * @param message is a String that queries the user as to whether the operation should be continued.
     * @return true if the user confirms, false if they click cancel
     */
    public static boolean confirmationDialogue(String header, String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Notification");
    alert.setHeaderText(header);
    alert.setContentText(message);
    Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            return true;
        }
        else {
            return false;
        }

}


    /**
     * Does rudimentary authentication for login. Checks to make sure neither user name or password are null.
     * Calls the logLoginAttempt function to log the login attempt in the persistent log.
     * @param username String, user name entered by the user.
     * @param password String, password entered by the user.
     * @return true if the user name and password pass initial validity checks. False if they do not.
     * @throws IOException
     */
    public static boolean checkAuthentication(String username, String password) throws IOException {
    //checks to make sure user and password are not null. Authenticates if values are present
    //for both fields.
    if(username.isEmpty() || password.isEmpty() ) {
        dialogueHandling.displayDialogue(true, dialogueReturnValues.NO_CONTENT);
        Scheduler sched = new Scheduler();
        if(!username.isEmpty()) {
            sched.logLoginAttempt(username, false);
        }
        else {
            sched.logLoginAttempt("Unknown", false);
        }

        return false;
    }
    return true;
}


    /**
     * Solicits feedback from the customer on how to proceed. See: confirmationDialogue if  a header is needed.
     * @param feedback is a String provided by the calling function
     * @return a boolean true value if the user clicks "Ok" false if they click cancel
     */
    public static boolean confirmationDialogue(String feedback) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, feedback);
        alert.setTitle("Please confirm?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Displays an error dialogue that requires the user to acknowledge the message before continuing.
     * This is used specifically for issues were errors are more complex, and built strings need
     * to provide additional information back to the user.
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
     * @param name String, name of the customer
     * @param address String, address
     * @param postal String, postal code
     * @param phone String, phone number
     * @return true if the values entered are valid, false if they do not pass validation
     */
    public static boolean validateCustomer(String name, String address, String postal, String phone) {
    String errorMessage = new String("Please resolve the following issues: \n");
    boolean valid = true;
    if(name.isEmpty()) {
        String str1 = new String(errorMessage);
        errorMessage = str1.concat("* Please enter the full name of the customer \n");
        valid = false;
    }
    if(address.isEmpty()) {
        String str1 = new String(errorMessage);
        errorMessage = str1.concat("* Please enter the full address of the customer \n");
        valid = false;
    }
    if(postal.isEmpty()) {
        String str1 = new String(errorMessage);
        errorMessage = str1.concat("* Please enter the full postal code \n");
        valid = false;
    }
    if(phone.isEmpty()) {
        String str1 = new String(errorMessage);
        errorMessage = str1.concat("* Please enter the full phone number \n");
        valid = false;
    }

    if(!valid) {
        validationDialogue(errorMessage);
        return valid;
    }
    else {
        return valid;
    }



}


    /**
     * Prints a dialogue that confirms that a customer has been added
     * @param C Represents a new customer record
     */
    public static void confirmCustomerAdded(Customer C) {
        String Header = "Customer Added!";
        String customer = "You have successfully added the following customer: \n" +
                "Name: " + C.getName() + " \n" +
                "Address: " + C.getAddress() + ", " + C.getPostalCode() + " \n" +
                "Phone: " + C.getPhoneNumber() + " \n" +
                "Country ID: " + Scheduler.getCountry(C.getCountryID()).getName() + " \n" +
                "Division ID: " + Scheduler.getDivision(C.getDivisionID()).getName() + " \n";

        confirmationDialogue(Header,customer);


}



    /**
     * Prints a dialogue that confirms that a customer has been updated
     * @param C Updated customer object
     */
    public static void confirmCustomerUpdated(Customer C) {
        String Header = "Customer Updated!";

        String customer = "You have successfully Updated the following customer: \n" +
                "Name: " + C.getName() + " \n" +
                "Address: " + C.getAddress() + ", " + C.getPostalCode() + " \n" +
                "Phone: " + C.getPhoneNumber() + " \n" +
                "Country ID: " + Scheduler.getCountry(C.getCountryID()).getName() + " \n" +
                "Division ID: " + Scheduler.getDivision(C.getDivisionID()).getName() + " \n";

        confirmationDialogue(Header,customer);


    }


    /**
     * Prints a dialogue that confirms whether or not the user truly wants to delete a customer record.
     * @param C The customer object that is ready to be deleted
     * @return true, if the end user confirmed the deletion. False if these chose "Cancel".
     */
    public static boolean confirmDeletionCustomer(Customer C) {
        String message = "Are you sure you want to delete the following customer? This action is not reversable! \n" +
                "Name: " + C.getName() + " \n" +
                "Address: " + C.getAddress() + ", " + C.getPostalCode() + " \n" +
                "Phone: " + C.getPhoneNumber() + " \n" +
                "Country ID: " + Scheduler.getCountry(C.getCountryID()).getName() + " \n" +
                "Division ID: " + Scheduler.getDivision(C.getDivisionID()).getName() + " \n";

        if(confirmationDialogue(message)) {
            return true;
        }
        else {
            return false;
        }
    }


    public static boolean validateAppointment(String title, String description, String location) {
        boolean valid = true;
        String errMessage = "Please resolve the following issues: \n";
        if(title.isEmpty()) {
            String strNew = errMessage;
            errMessage = strNew.concat("* Please enter a title \n");
            valid = false;
        }
        if(description.isEmpty()) {
            String strNew = errMessage;
            errMessage = strNew.concat("* Please enter a description \n");
            valid = false;
        }
        if(location.isEmpty()) {
            String strNew = errMessage;
            errMessage = strNew.concat("* Please enter a location \n");
            valid = false;
        }

        if(!valid) {
            validationDialogue(errMessage);
        }

        return valid;
    }

    /**
     * Displays a dialogue that confirms that an appointment has been added successfully
     * @param A, The appointment that has been added.
     */
    public static void confirmAppointmentAdded (Appointment A) {
        String header = (dialogueReturnValues.APPT_ADDED_SUCCESSFULLY).toString();
        String message = "You have successfully added the following customer: \n" +
                "Title: " + A.getTitle() + "\n" +
                "Description: " + A.getDescription() + "\n" +
                "Location: " + A.getLocation() + "\n" +
                "Contact Name: " + A.getContactName() + "\n" +
                "Customer Name: " + Scheduler.returnCustomerName(A.getCustomerID()) + "\n" +
                "Start Time: " + A.getFormattedStart() + "\n" +
                "End Time: " + A.getFormattedEnd() + "\n";

        dialogueHandling.confirmationDialogue(header, message);

    }


    public static boolean confirmAppointmentModification(Appointment A) {

        String message = "Please confirm that you would like to make the following changes? \n" +
                "Title: " + A.getTitle() + "\n" +
                "Description: " + A.getDescription() + "\n" +
                "Location: " + A.getLocation() + "\n" +
                "Contact Name: " + A.getContactName() + "\n" +
                "Customer Name: " + Scheduler.returnCustomerName(A.getCustomerID()) + "\n" +
                "Start Time: " + A.getFormattedStart() + "\n" +
                "End Time: " + A.getFormattedEnd() + "\n";
        if(confirmationDialogue(message)) {
            return true;
        }

        return false;

    }


}
