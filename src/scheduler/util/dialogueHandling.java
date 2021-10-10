package scheduler.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import scheduler.model.Customer;
import scheduler.model.Scheduler;

import java.io.IOException;
import java.util.Optional;

public abstract class dialogueHandling {

    /**
     *
     * Used to display basic alert and confirmation dialogues to the user. Errors and confirmation
     * messages are displayed in the type of dialogue indicated by the boolean parameter. This function
     * assumes that the message is a single string, that does not require formatting.
     * @param error a true value will display an "Error" dialogue. A false value will result
     *              in a "Confirmation" dialogue being displayed.
     * @param code  an enum value that will be used to display the correct feedback in the dialogue
     *              box. It is used to insert the appropriate string
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

public static boolean confirmationDialogue(String header, String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Notification");
    alert.setHeaderText(header);
    alert.setContentText(message);
    Optional<ButtonType> result = alert.showAndWait();

    return true;
}


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
    public static void confirmCustomerAdded(String name, String address, String postal, String phone, String country, String division) {
        String Header = "Customer Added!";
        String customer = "You have successfully added the following customer: \n" +
                "Name: " + name + " \n" +
                "Address: " + address + ", " + postal + " \n" +
                "Phone: " + phone + " \n" +
                "Country ID: " + country + " \n" +
                "Division ID: " + division + " \n";

        confirmationDialogue(Header,customer);


}



}
